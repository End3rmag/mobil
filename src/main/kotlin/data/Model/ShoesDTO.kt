package org.example.data.Model

import org.example.domein.Response.ShoesResponse

data class ShoesDTO(
    val shoesId : Int,
    val shoesName : String,
    val shoesDescription : String,
    val shoesURL : String,
    val cotegory : String

)
{
    fun mapToShoesResponse() : ShoesResponse {
        return ShoesResponse(shoesId, shoesName, shoesURL, shoesDescription, cotegory )
    }
}

