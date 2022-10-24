package aaa.bivizul.a39project.data.network

import aaa.bivizul.a39project.domain.model.Paymet
import aaa.bivizul.a39project.domain.model.Paymetg
import aaa.bivizul.a39project.domain.model.Paymets
import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETBASEURL
import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETGURL
import aaa.bivizul.a39project.domain.util.Paymetcon.PAYMETITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class PaymetApi {

    val paymethc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    private fun HttpRequestBuilder.paymetbase(path: String) {
        url {
            takeFrom(PAYMETBASEURL)
            encodedPath = path
        }
    }

    suspend fun getPaymetItem(): List<Paymets> {
        val getpaymetitemurl = PAYMETITEMURL
        val paymethr = paymethc.get { paymetbase(getpaymetitemurl) }
        val getpaymetitembody = paymethr.body<List<Paymets>>()
        return getpaymetitembody
    }

    suspend fun getPaymetg(paymet: Paymet): Paymetg {
        val getpaymeturl = PAYMETGURL
        val paymethr = paymethc.post {
            paymetbase(getpaymeturl)
            contentType(Json)
            setBody(paymet)
        }
        val getpaymetbody = paymethr.body<Paymetg>()
        return getpaymetbody
    }

}