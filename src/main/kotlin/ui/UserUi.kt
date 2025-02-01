package org.example.ui

import org.example.domein.Request.AuthorizeRequest
import org.example.domein.Request.ChangePasswordRequest
import org.example.domein.Request.ChangeProfileRequest
import org.example.domein.Request.RegistrationRequest
import org.example.domein.Response.UserResponse
import org.example.domein.UserUseCase
import java.lang.StringBuilder

class UserUi(private val userUseCase:UserUseCase) {
    var userauto: UserResponse?  = null
fun registration(){
    println("Введите ваше имя")
    val firstname = readlnOrNull()
    checkNotNull(firstname){
        "Имя не должно отсутствовать"
    }
    println("Введите вашу почту")
    val email = readlnOrNull()
    checkNotNull(email){
        "Почта не должна отсутствовать"
    }
    println("Введите ваш пароль")
    val password = readlnOrNull()
    checkNotNull(password){
        "Параоль не должен отсутствовать"
    }
    val registrationRequest = RegistrationRequest(
        firstName = firstname,
        email = email,
        password = password

    )
    userUseCase.registration(registrationRequest)

}
    fun autorize(){
        println("Введите вашу почту")
        val email = readlnOrNull()
        checkNotNull(email){
            "Почта не должна отсутствовать"
        }
        println("Введите ваш пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Параоль не должен отсутствовать"
        }

        val authorizeRequest = AuthorizeRequest(
            email = email,
            password = password
        )

        val user = userUseCase.authorize(authorizeRequest)
        userauto=user
        println(UserResponseToString(user))
    }

    fun changePassword(){
        checkNotNull(userauto){
            "нет авторизации"
        }
        println("Введите ваш пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Параоль не должен отсутствовать"
        }
        val changePasswordRequest = ChangePasswordRequest(
            Id = userauto!!.Id,
            newPassword = password
        )
        userUseCase.changePassword(changePasswordRequest)
    }

    fun changeProfile(){
        checkNotNull(userauto){
            "нет авторизации"
        }
        println("Введите ваше имя")
        val firstName = readlnOrNull()

        println("Введите вашe фамилию")
        val lastName = readlnOrNull()

        println("Введите ваш email")
        val email = readlnOrNull()

        println("Введите ваш телефон")
        val phone = readlnOrNull()

        println("Введите ваш адресс")
        val address = readlnOrNull()

        val changeProfileRequest = ChangeProfileRequest(
            Id = userauto!!.Id,
            newFirstName = firstName,
            newLastName = lastName,
            newEmail = email,
            newPhone = phone,
            newAddress = address
        )
        userUseCase.changeProfile(changeProfileRequest)
    }



    fun UserResponseToString(userResponse: UserResponse): String{
        val printOutput = StringBuilder()
        printOutput.append("Ваша почта ${userResponse.email}")
        printOutput.appendLine()
        printOutput.append("Ваше имя ${userResponse.firstName}")
        if(!userResponse.lasnName.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваша фамилия ${userResponse.lasnName}")
        }
        if(!userResponse.phone.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваш телефон ${userResponse.phone}")
        }
        if(!userResponse.address.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваш адесс ${userResponse.address}")
        }
        return printOutput.toString()
    }
}