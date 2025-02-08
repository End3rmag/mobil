package org.example

import ShoesRepositoryImpl
import ShoesUi
import ShoesUseCaseImpl
import org.example.data.*
import org.example.domein.UserUseCaseImpl
import org.example.ui.MainMenuUi

import org.example.ui.UserUi


fun main() {
    val shoesRepository = ShoesRepositoryImpl()
    val favouriteRepository = FavouriteRepositoryIMPL(shoesRepository)
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository, favouriteRepository, shoesRepository )
    val shoesUseCase = ShoesUseCaseImpl(shoesRepository)
    val userUi = UserUi(userUseCase, favouriteRepository)
    val shoesUi = ShoesUi(shoesUseCase, userUi, favouriteRepository)
    val mainMenuUi = MainMenuUi(userUi, shoesUi)
    mainMenuUi.displayAutorizationMenu()
}
