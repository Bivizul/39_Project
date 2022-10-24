package aaa.bivizul.a39project.ui.paymetp

import aaa.bivizul.a39project.domain.model.Paymetvar
import aaa.bivizul.a39project.domain.util.getPaymetactoff
import aaa.bivizul.a39project.domain.util.sigPaymetoff
import aaa.bivizul.a39project.domain.util.paymetct
import aaa.bivizul.a39project.ui.paymetwidget.Paymetcp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun PaymetpContent(
    component: PaymetpModel,
    modifier: Modifier = Modifier
) {

    val paymetg by component.state.collectAsState()
    val model by component.models.subscribeAsState()


    paymetg?.paymetg?.let {
        if (it == Paymetvar.VSNO.vs) {
            component.onReplace()
        } else if (it == Paymetvar.VSNP.vs) {
            sigPaymetoff()
            component.onReplace()
        } else {
            paymetct(model.activity, it)
            getPaymetactoff(model.activity)
        }
    }

    Paymetcp(modifier = modifier)
}