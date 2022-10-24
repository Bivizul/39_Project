package aaa.bivizul.a39project.data.repository

import aaa.bivizul.a39project.data.network.PaymetApi
import aaa.bivizul.a39project.domain.model.Paymets
import aaa.bivizul.a39project.domain.util.paymetIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaymetsRepository {

    private val paymetApi = PaymetApi()
    private val paymetjob = SupervisorJob()
    private val paymetscope = CoroutineScope(paymetIoDispatcher + paymetjob)

    private val _paymetItemList = MutableStateFlow<List<Paymets>?>(null)
    val paymetsList: StateFlow<List<Paymets>?> = _paymetItemList.asStateFlow()

    init {
        getPaymetItem()
    }

    fun getPaymetItem() {
        paymetscope.launch {
            val response = paymetApi.getPaymetItem()
            _paymetItemList.emit(response)
        }
    }

}