package org.example.data

import org.example.data.Model.ShoesDTO
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Request.UpdateShoesRequest

interface ShoesRepository {
    interface ShoesRepository {
        fun addShoes(addShoesRequest: ShoesAddRequest): ShoesDTO
        fun getAllShoes(): List<ShoesDTO>
        fun removeShoes(shoesId: Int): Boolean
        fun findShoesById(shoesId: Int): ShoesDTO?
        fun addShoesById(updateShoesRequest: UpdateShoesRequest): ShoesDTO
    }

}