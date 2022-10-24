package aaa.bivizul.a39project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val paymetIoDispatcher: CoroutineContext
internal expect val paymetUiDispatcher: CoroutineContext

internal expect fun getPaymetmm(): String
internal expect fun getPaymetsim(paymetcon: Any): String
internal expect fun getPaymetid(paymetcon: Any): String
internal expect fun getPaymetl(): String
internal expect fun getPaymett(): String
internal expect fun getPaymetdlg(paymetcon: Any)
internal expect fun checkPaymetnet(paymetcon: Any): Boolean
internal expect fun sigPaymetoff()
internal expect fun getPaymetactoff(paymetcon: Any)
internal expect fun paymetct(paymetcon: Any, paymetcc: String)