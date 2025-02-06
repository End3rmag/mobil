package org.example

import ShoesRepositoryImpl
import ShoesUi
import ShoesUseCaseImpl
import org.example.data.FavouriteRepository
import org.example.data.FavouriteRepositoryIMPL
import org.example.data.UserRepository
import org.example.data.UserRepositoryImpl
import org.example.domein.UserUseCaseImpl
import org.example.ui.MainMenuUi

import org.example.ui.UserUi


fun main() {
    val shoesRepository = ShoesRepositoryImpl()
    val favouriteRepository = FavouriteRepositoryIMPL()
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository, favouriteRepository, shoesRepository )
    val userUi = UserUi(userUseCase)
    val shoesUseCase = ShoesUseCaseImpl(shoesRepository)
    val shoesUi = ShoesUi(shoesUseCase)
    val mainMenuUi = MainMenuUi(userUi, shoesUi)
    mainMenuUi.displayAutorizationMenu()
}
