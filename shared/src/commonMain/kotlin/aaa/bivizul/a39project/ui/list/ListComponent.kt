package aaa.bivizul.a39project.ui.list

import aaa.bivizul.a39project.data.repository.PaymetsRepository
import aaa.bivizul.a39project.domain.model.Paymets
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    paymetsRepository: PaymetsRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<Paymets>?> = paymetsRepository.paymetsList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}