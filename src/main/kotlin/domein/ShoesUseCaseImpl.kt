package org.example.domein

import org.example.data.Model.ShoesDTO
import org.example.data.ShoesRepository
import org.example.data.shoesList
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Response.ShoesResponse

val shoesSourse = shoesList.toMutableList()
class ShoesUseCaseImpl(private val shoesRepository: ShoesRepository): ShoesUseCase {

    override fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesResponse {
        val newShoes = ShoesDTO(
            shoesId = shoesAddRequest.shoesId,
            shoesURL = shoesAddRequest.shoesUrl,
            shoesName = shoesAddRequest.shoesName,
            shoesDescription = shoesAddRequest.shoesDescription,
            cotegory = shoesAddRequest.category
        )
        shoesSourse.add(newShoes)

        return ShoesDTOToShoesResponse(newShoes)
    }

    override fun removeShoes(shoesID: Int): Boolean {
        return shoesSourse.removeIf{it.shoesId == shoesID}
    }

    override fun returnAllShoes(): List<ShoesResponse> {
        val allShoes = shoesRepository.getAllShoes().
        map { ShoesDTOToShoesResponse(it)}
        return allShoes
    }

    override fun returnShoes(shoesID: Int): ShoesResponse {
        val fingshoes = shoesRepository.getAllShoes().find { it.shoesId==shoesID }
        checkNotNull(fingshoes)
        return ShoesDTOToShoesResponse(fingshoes)
    }
}