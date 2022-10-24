package aaa.bivizul.a39project.ui.paymetwidget

import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETAN
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Paymetcp(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = PAYMETAN,
            style = MaterialTheme.typography.h2
        )
        CircularProgressIndicator(
            modifier = modifier.size(110.dp),
            color = MaterialTheme.colors.primary,
            strokeWidth = 11.dp
        )
    }
}