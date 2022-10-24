package aaa.bivizul.a39project.ui.item

import aaa.bivizul.a39project.data.repository.PaymetsRepository
import aaa.bivizul.a39project.domain.model.Paymets
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    paymetsRepository: PaymetsRepository,
    paymetItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedPaymetItemId = paymetItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<Paymets>?> =
        paymetsRepository.paymetsList

}