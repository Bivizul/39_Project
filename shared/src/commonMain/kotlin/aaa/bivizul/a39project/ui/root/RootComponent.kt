package aaa.bivizul.a39project.ui.root

import aaa.bivizul.a39project.data.repository.PaymetRepository
import aaa.bivizul.a39project.data.repository.PaymetsRepository
import aaa.bivizul.a39project.ui.item.ItemComponent
import aaa.bivizul.a39project.ui.item.ItemModel
import aaa.bivizul.a39project.ui.list.ListComponent
import aaa.bivizul.a39project.ui.list.ListModel
import aaa.bivizul.a39project.ui.main.MainComponent
import aaa.bivizul.a39project.ui.main.MainModel
import aaa.bivizul.a39project.ui.settings.SettingsComponent
import aaa.bivizul.a39project.ui.settings.SettingsModel
import aaa.bivizul.a39project.ui.paymetp.PaymetpComponent
import aaa.bivizul.a39project.ui.paymetp.PaymetpModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : RootModel, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val paymetRepository = PaymetRepository()
    val paymetsRepository = PaymetsRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.PaymetpConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, RootModel.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): RootModel.Child =
        when (config) {
            is Config.PaymetpConfig -> RootModel.Child.PaymetpChild(
                setPaymetp(componentContext)
            )
            is Config.MainConfig -> RootModel.Child.MainChild(
                setMain(componentContext)
            )
            is Config.ListConfig -> RootModel.Child.ListChild(
                setList(componentContext)
            )
            is Config.ItemConfig -> RootModel.Child.ItemChild(
                setItem(componentContext, config)
            )
            is Config.SettingsConfig -> RootModel.Child.SettingsChild(
                setSettings(componentContext)
            )
        }

    private fun setPaymetp(
        componentContext: ComponentContext
    ): PaymetpModel = PaymetpComponent(
        componentContext = componentContext,
        context = context,
        paymetRepository = paymetRepository,
        onReplaceToMain = {
            navigation.replaceCurrent(Config.MainConfig)
        }
    )

    private fun setMain(
        componentContext: ComponentContext
    ): MainModel = MainComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.ListConfig)
        },
        onClickSettings = {
            navigation.push(Config.SettingsConfig)
        }
    )

    private fun setList(
        componentContext: ComponentContext
    ): ListModel = ListComponent(
        componentContext = componentContext,
        paymetsRepository = paymetsRepository,
        onClickListItem = { itemId ->
            navigation.push(Config.ItemConfig(itemId = itemId))
        },
    )

    private fun setItem(
        componentContext: ComponentContext,
        config: Config.ItemConfig
    ): ItemModel = ItemComponent(
        componentContext = componentContext,
        paymetsRepository = paymetsRepository,
        paymetItemId = config.itemId
    )

    private fun setSettings(
        componentContext: ComponentContext
    ): SettingsModel = SettingsComponent(
        componentContext = componentContext,
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object PaymetpConfig : Config()

        @Parcelize
        object MainConfig : Config()

        @Parcelize
        object ListConfig : Config()

        @Parcelize
        data class ItemConfig(val itemId: Int) : Config()

        @Parcelize
        object SettingsConfig : Config()
    }
}