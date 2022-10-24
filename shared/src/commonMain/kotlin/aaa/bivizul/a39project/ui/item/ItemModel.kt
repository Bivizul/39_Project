package aaa.bivizul.a39project.ui.item

import aaa.bivizul.a39project.domain.model.Paymets
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<Paymets>?>

    data class Model(
        val selectedPaymetItemId: Int
    )

}