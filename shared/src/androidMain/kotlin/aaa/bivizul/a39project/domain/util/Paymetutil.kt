@file:Suppress("DEPRECATION")

package aaa.bivizul.a39project.domain.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.telephony.TelephonyManager
import androidx.browser.customtabs.CustomTabsIntent
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val paymetUiDispatcher: CoroutineContext = Dispatchers.Main

actual val paymetIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getPaymetmm(): String {
    val manfacpaymet = android.os.Build.MANUFACTURER
    val modelpaymet = android.os.Build.MODEL
    return "$manfacpaymet $modelpaymet"
}

actual fun getPaymetsim(paymetcon: Any): String {
    val context = paymetcon as Context
    val telmanpaymet = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanpaymet.simCountryIso
}

actual fun getPaymetid(paymetcon: Any): String {
    val context = paymetcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefpaymet", Context.MODE_PRIVATE)
    var paymetid = sharedPreferences.getString("paymet_key", "nopaymet") ?: "nopaymet"
    if (paymetid == "nopaymet") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        paymetid = datetime + randomNum
        sharedPreferences.edit().putString("paymet_key", paymetid).apply()
    }
    return paymetid
}

actual fun getPaymetl(): String {
    return Locale.getDefault().language
}

actual fun getPaymett(): String {
    val paymettz: String = SimpleDateFormat("z", Locale.getDefault()).format(
        Calendar.getInstance(
            TimeZone.getTimeZone("GMT"),
            Locale.getDefault()
        ).time
    ).replace("GMT", "")
    val paymetzone = if (paymettz.contains(":")) paymettz else "default"
    return paymetzone
}

actual fun getPaymetdlg(paymetcon: Any) {
    val context = paymetcon as Context
    val activity = paymetcon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Error connect")
        setMessage("Please try again later")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkPaymetnet(paymetcon: Any): Boolean {
    val context = paymetcon as Context
    val conmanpaymet =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfpaymet = conmanpaymet.activeNetworkInfo
    return netinfpaymet != null && netinfpaymet.isConnected
}

actual fun sigPaymetoff() {
    OneSignal.disablePush(true)
}

internal actual fun getPaymetactoff(paymetcon: Any) {
    val paymeta = paymetcon as Activity
    paymeta.finish()
    System.exit(0)
}

internal actual fun paymetct(paymetcon: Any, paymetcc: String) {
    val context = paymetcon as Context
    val paymeta = (context as? Activity)
    val paymetpn = "com.android.chrome"
    val paymetb = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (paymetpn != null) {
        paymetb.intent.setPackage(paymetpn)
        paymetb.launchUrl(context, Uri.parse(paymetcc))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(paymetcc))
        paymeta?.startActivity(i)
    }
}