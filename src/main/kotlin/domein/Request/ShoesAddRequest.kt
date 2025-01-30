package org.example.domein.Request

data class ShoesAddRequest(
    val shoesId: Int,
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,
)
