package aaa.bivizul.a39project.data.repository

import aaa.bivizul.a39project.data.network.PaymetApi
import aaa.bivizul.a39project.domain.model.Paymet
import aaa.bivizul.a39project.domain.model.Paymetg
import aaa.bivizul.a39project.domain.util.paymetIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaymetRepository {

    private val paymetApi = PaymetApi()
    private val paymetjob = SupervisorJob()
    private val paymetscope = CoroutineScope(paymetIoDispatcher + paymetjob)

    private val _paymetg = MutableStateFlow<Paymetg?>(null)
    val paymetg: StateFlow<Paymetg?> = _paymetg.asStateFlow()

    fun getPaymetg(paymet: Paymet) {
        paymetscope.launch {
            val response = paymetApi.getPaymetg(paymet)
            _paymetg.emit(response)
        }
    }

}