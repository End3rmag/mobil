package org.example.domein

import org.example.data.Model.ShoesDTO
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Response.ShoesResponse

interface ShoesUseCase {
    fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesResponse
    fun removeShoes(shoesID:Int):Boolean
    fun returnAllShoes():List<ShoesResponse>
    fun returnShoes(shoesID: Int):ShoesResponse
}