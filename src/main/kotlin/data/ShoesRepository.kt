package org.example.data

import org.example.data.Model.ShoesDTO
import org.example.domein.Request.ShoesAddRequest

interface ShoesRepository {
    fun addShoes(shoesAddRequest: ShoesAddRequest):ShoesDTO
    fun getAllShoes():List<ShoesDTO>
    fun removeShoes(shoesID:Int):Boolean
}