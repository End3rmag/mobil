package org.example

import org.example.data.UserRepository
import org.example.data.UserRepositoryImpl
import org.example.domein.UserUseCaseImpl
import org.example.ui.UserUi


fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUi = UserUi(userUseCase)
    userUi.autorize()
    userUi.changePassword()
    userUi.autorize()
}
