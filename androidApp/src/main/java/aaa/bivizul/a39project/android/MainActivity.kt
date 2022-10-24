package aaa.bivizul.a39project.android

import aaa.bivizul.a39project.domain.util.checkPaymetnet
import aaa.bivizul.a39project.domain.util.getPaymetdlg
import aaa.bivizul.a39project.ui.root.RootComponent
import aaa.bivizul.a39project.ui.root.RootContent
import aaa.bivizul.a39project.ui.paymetwidget.Paymetibl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xB2008AAC),
            background = Color(0x1B006179),
            secondary = Color(0x9FD30C0C),
            onPrimary = Color(0xFFC7C7C7),
            onBackground = Color(0xFFC7C7C7),
        )
    } else {
        lightColors(
            primary = Color(0xB200CDFF),
            background = Color(0xE98800FF),
            secondary = Color(0x9FD30C0C),
            onPrimary = Color(0xFFFFFFFF),
            onBackground = Color(0xFFFFFFFF),
        )
    }
    val typography = Typography(
        h1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 96.sp,
            letterSpacing = (-1.5).sp
        ),
        h2 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 60.sp,
            letterSpacing = (-0.5).sp
        ),
        h3 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 48.sp,
            letterSpacing = 0.sp
        ),
        h4 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 34.sp,
            letterSpacing = 0.25.sp
        ),
        h5 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            letterSpacing = 0.sp
        ),
        h6 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 22.sp,
            letterSpacing = 0.15.sp
        ),
        body1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(16.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(24.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkPaymetnet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Paymetibl()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                        RootContent(rootModel = root)
                    }
                }
            }
        } else {
            getPaymetdlg(this)
        }
    }
}

