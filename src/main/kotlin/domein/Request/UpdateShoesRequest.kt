package org.example.domein.Request


data class UpdateShoesRequest(
    val shoesId: Int,
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,
)//s