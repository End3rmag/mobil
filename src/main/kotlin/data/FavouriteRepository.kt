package org.example.data


import org.example.data.Model.ShoesDTO
import org.example.domein.Request.AddFavouriteRequest

interface FavouriteRepository {

    fun getAllFavourites(userId: Int): List<ShoesDTO>
    fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest)
    fun removeFavourites(shoesId: Int): Boolean
    fun getFavouritesByUserId(userId:Int): IntArray

}