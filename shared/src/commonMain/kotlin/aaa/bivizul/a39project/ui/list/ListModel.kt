package aaa.bivizul.a39project.ui.list

import aaa.bivizul.a39project.domain.model.Paymets
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<Paymets>?>

    fun onClickListItemModel(id: Int)

}