package aaa.bivizul.a39project.domain.model

@kotlinx.serialization.Serializable
data class Paymets(
    val id: Int,
    val paymettit: String,
    val paymetdesc: String,
    val paymetin: List<Paymetin>,
)