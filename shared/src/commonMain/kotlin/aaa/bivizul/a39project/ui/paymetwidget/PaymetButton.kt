package aaa.bivizul.a39project.ui.paymetwidget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PaymetButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        elevation = ButtonDefaults.elevation(),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(8.dp, MaterialTheme.colors.onPrimary)
    ) {
        Text(
            text = text,
            modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
    }

}