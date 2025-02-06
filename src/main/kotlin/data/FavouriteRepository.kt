package org.example.data

import org.example.domein.Request.AddFavouriteRequest

interface FavouriteRepository {

    fun getAllFavourites()
    fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest)
    fun removeFavourites()
    fun getFavouritesByUserId()

}