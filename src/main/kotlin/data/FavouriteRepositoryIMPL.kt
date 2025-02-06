package org.example.data

import org.example.data.Model.FavouriteDTO
import org.example.domein.Request.AddFavouriteRequest

class FavouriteRepositoryIMPL: FavouriteRepository {

    private val favourite: MutableList<FavouriteDTO>  = favouriteList.toMutableList()
    override fun getAllFavourites() {

    }

    override fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest) {
    }

    override fun removeFavourites() {
       throw NotImplementedError()
    }

    override fun getFavouritesByUserId(userId: Int): IntArray {
        val findFavouriteByUsers = favourite.filter{it.userId ==  userId }
        return findFavouriteByUsers.map{ it.shoesId }.toIntArray()
    }
}