package org.example.data

import org.example.data.Model.ShoesDTO
import org.example.domein.Request.ShoesAddRequest

class ShoesRepositoryImpl:ShoesRepository {
    val shoesSource = shoesList.toMutableList()
    override fun addShoes(shoesAddRequest: ShoesAddRequest):ShoesDTO{
        val newShoes = ShoesDTO(
            shoesId = shoesSource.size+1,
            shoesName = shoesAddRequest.shoesName,
            shoesDescription = shoesAddRequest.shoesDescription,
            shoesURL = shoesAddRequest.shoesUrl,
            cotegory = shoesAddRequest.category
        )
        shoesSource.add(newShoes)
        return newShoes
    }

    override fun getAllShoes():List<ShoesDTO> = shoesSource


    override fun removeShoes(shoesID:Int):Boolean {
        return shoesSource.removeIf{it.shoesId == shoesID}
    }
}

