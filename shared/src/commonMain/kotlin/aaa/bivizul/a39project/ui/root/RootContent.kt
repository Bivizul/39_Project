package aaa.bivizul.a39project.ui.root

import aaa.bivizul.a39project.ui.item.ItemContent
import aaa.bivizul.a39project.ui.list.ListContent
import aaa.bivizul.a39project.ui.main.MainContent
import aaa.bivizul.a39project.ui.settings.SettingsContent
import aaa.bivizul.a39project.ui.paymetp.PaymetpContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootContent(
    rootModel: RootModel,
    modifier: Modifier = Modifier
) {

    val childStack by rootModel.childStack.subscribeAsState()

    Children(
        stack = childStack,
        modifier = modifier,
        animation = stackAnimation(fade() + slide()),
    ) {
        when (val child = it.instance) {
            is RootModel.Child.PaymetpChild -> PaymetpContent(component = child.component)
            is RootModel.Child.MainChild -> MainContent(component = child.component)
            is RootModel.Child.ListChild -> ListContent(component = child.component)
            is RootModel.Child.ItemChild -> ItemContent(component = child.component)
            is RootModel.Child.SettingsChild -> SettingsContent(component = child.component)
        }
    }

}