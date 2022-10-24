package aaa.bivizul.a39project.android

import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETOSAI
import android.app.Application
import com.onesignal.OneSignal

class A39PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(PAYMETOSAI)

    }

}