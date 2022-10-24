package aaa.bivizul.a39project.ui.list

import aaa.bivizul.a39project.ui.paymetwidget.PaymetButton
import aaa.bivizul.a39project.ui.paymetwidget.Paymetcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val paymetItemList by component.state.collectAsState()

    if (paymetItemList != null) {
        paymetItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                items(list) { paymetItem ->
                    PaymetButton(
                        onClick = { component.onClickListItemModel(id = paymetItem.id) },
                        text = paymetItem.paymettit
                    )
                }
            }
        }
    } else {
        Paymetcp(modifier = modifier)
    }

}