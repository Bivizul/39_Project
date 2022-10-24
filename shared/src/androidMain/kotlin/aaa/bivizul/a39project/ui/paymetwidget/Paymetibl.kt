package aaa.bivizul.a39project.ui.paymetwidget

import aaa.bivizul.a39project.domain.util.Paymetcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
actual fun Paymetibl() {

    val paymetorient = LocalConfiguration.current.orientation
    val paymetImgModel = when (paymetorient) {
        Configuration.ORIENTATION_PORTRAIT -> Paymetcon.PAYMETBV
        else -> Paymetcon.PAYMETBH
    }

    GlideImage(
        imageModel = { paymetImgModel },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )

}