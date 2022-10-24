package aaa.bivizul.a39project.ui.paymetp

import aaa.bivizul.a39project.data.repository.PaymetRepository
import aaa.bivizul.a39project.domain.model.Paymet
import aaa.bivizul.a39project.domain.model.Paymetg
import aaa.bivizul.a39project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class PaymetpComponent(
    componentContext: ComponentContext,
    context: Any,
    paymetRepository: PaymetRepository,
    private val onReplaceToMain: () -> Unit
) : PaymetpModel, ComponentContext by componentContext {

    private val _models = MutableValue(PaymetpModel.Model(activity = context))
    override val models: Value<PaymetpModel.Model> = _models
    override val state: StateFlow<Paymetg?> = paymetRepository.paymetg

    init {
        try {
            paymetRepository.getPaymetg(
                Paymet(
                    getPaymetmm(),
                    getPaymetsim(context),
                    getPaymetid(context),
                    getPaymetl(),
                    getPaymett()
                )
            )
        } catch (e: Exception) {
            getPaymetdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}