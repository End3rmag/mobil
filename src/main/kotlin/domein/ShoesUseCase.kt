package org.example.domein

import org.example.domein.Request.GetAllFilterShoesRequest
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Request.UpdateShoesRequest
import org.example.domein.Response.ShoesResponse

interface ShoesUseCase {
    fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesResponse
    fun removeShoesById(shoesID:Int):Boolean
    fun updateShoes(updateShoesRequest: UpdateShoesRequest): ShoesResponse
    fun getAllFilterShoes (getAllFilterShoesRequest: GetAllFilterShoesRequest): List<ShoesResponse>
}