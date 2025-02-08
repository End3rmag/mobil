package org.example.data

import org.example.data.Model.FavouriteDTO
import org.example.data.Model.ShoesDTO
import org.example.domein.Request.AddFavouriteRequest

class FavouriteRepositoryIMPL(private val shoesRepository: ShoesRepository): FavouriteRepository {

    private val favourite: MutableList<FavouriteDTO> = favouriteList.toMutableList()

    override fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest) {
        addFavouriteRequest.forEach { request ->
            // Проверка наличия в избранном
            if (!favourite.any { it.userId == request.userID && it.shoesId == request.shoesID }) {
                val favouriteDTO = FavouriteDTO(userId = request.userID, shoesId = request.shoesID)
                favourite.add(favouriteDTO)
                println("Обувь добавленa в избранное")
            } else {
                println("Эта обувь уже есть в избранном.")
            }
        }
    }


    override fun removeFavourites(shoesId: Int): Boolean {
        return favourite.removeIf{favourite.contains(it)}
    }

    override fun getFavouritesByUserId(userId: Int): IntArray {
        val findFavouriteByUsers = favourite.filter{it.userId ==  userId }
        return findFavouriteByUsers.map{ it.shoesId }.toIntArray()
    }

    override fun getAllFavourites(userId: Int): List<ShoesDTO> {
        return favourite.filter { it.userId == userId }
            .mapNotNull { favouriteDTO ->
                shoesRepository.findShoesById(favouriteDTO.shoesId)
            }
    }
}
//s