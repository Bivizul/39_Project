package aaa.bivizul.a39project.ui.item

import aaa.bivizul.a39project.domain.model.Paymetin
import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETES
import aaa.bivizul.a39project.ui.paymetwidget.Paymetcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val paymetItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    if (paymetItemList != null) {
        paymetItemList?.let { list ->
            list[model.selectedPaymetItemId - 1].let { paymets ->
                LazyColumn(
                    modifier = modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Column {
                            Text(
                                text = paymets.paymettit,
                                modifier = modifier.padding(bottom = 8.dp),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h4
                            )
                            if (paymets.paymetdesc != PAYMETES) {
                                Text(
                                    text = paymets.paymetdesc,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                    if (paymets.paymetin != emptyList<Paymetin>()) {
                        items(paymets.paymetin) { paymetin ->
                            Column {
                                Text(
                                    text = paymetin.paymetsubtit,
                                    modifier = modifier.padding(bottom = 8.dp),
                                    style = MaterialTheme.typography.h5
                                )
                                Text(
                                    text = paymetin.paymetsubdesc,
                                    style = MaterialTheme.typography.body1
                                )

                            }
                        }
                    }


                }
            }
        }
    } else {
        Paymetcp(modifier = modifier)
    }
}