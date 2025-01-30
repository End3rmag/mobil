package org.example.data.Model

data class ShoesDTO(
    val shoesId : Int,
    val shoesName : String,
    val shoesDescription : String? = null,
    val shoesURL : String,
    val cotegory : String
)