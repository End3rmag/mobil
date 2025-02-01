package org.example

import org.example.data.ShoesRepositoryImpl
import org.example.data.UserRepository
import org.example.data.UserRepositoryImpl
import org.example.domein.ShoesUseCaseImpl
import org.example.domein.UserUseCaseImpl
import org.example.ui.MainMenuUi
import org.example.ui.ShoesUi
import org.example.ui.UserUi


fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUi = UserUi(userUseCase)
    val shoesRepository = ShoesRepositoryImpl()
    val shoesUseCase = ShoesUseCaseImpl(shoesRepository)
    val shoesUi = ShoesUi(shoesUseCase)
    val mainMenuUi = MainMenuUi(userUi, shoesUi)
    mainMenuUi.displayAutorizationMenu()
}
