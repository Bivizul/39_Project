package aaa.bivizul.a39project.ui.paymetp

import aaa.bivizul.a39project.domain.model.Paymetg
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface PaymetpModel {

    val models: Value<Model>
    val state: StateFlow<Paymetg?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}