package org.example.domein

import org.example.data.UserRepository
import org.example.domein.Request.AuthorizeRequest
import org.example.domein.Request.ChangePasswordRequest
import org.example.domein.Request.ChangeProfileRequest
import org.example.domein.Request.RegistrationRequest
import org.example.domein.Response.UserResponse

class UserUseCaseImpl(private val userRepository: UserRepository): UserUseCase {
    override fun authorize(authorizeRequest: AuthorizeRequest): UserResponse {
        val findUser = userRepository.getAllUsers().firstOrNull{it.email == authorizeRequest.email}
        checkNotNull(findUser){
            "Пользователь с такой почтой не найден"
        }
        require(findUser.password  == authorizeRequest.password){
            "Пароли не совпадают"
        }
return  UserDTOToUserResponse(findUser)
    }

    override fun registration(registrationRequest: RegistrationRequest): UserResponse {
        val isUnique = userRepository.getAllUsers().firstOrNull{it.email == registrationRequest.email}==null
        require(isUnique) {
            "Такая почта уже существует"
        }
        val newUser = userRepository.addUsers(registrationRequest)
        return UserDTOToUserResponse(newUser)
    }

    override fun changePassword(changePasswordRequest: ChangePasswordRequest){
        var updatedUser = userRepository.findUsersById(changePasswordRequest.Id)
        updatedUser.password = changePasswordRequest.newPassword
        userRepository.updateUsersById(changePasswordRequest.Id,updatedUser)
    }

    override fun changeProfile(changeProfileRequest: ChangeProfileRequest) {
        var updateProfile = userRepository.findUsersById(changeProfileRequest.Id)
        if (!changeProfileRequest.newFirstName.isNullOrEmpty()) updateProfile.firstName = changeProfileRequest.newFirstName
        if (!changeProfileRequest.newLastName.isNullOrEmpty()) updateProfile.lasnName =changeProfileRequest.newLastName
        if (!changeProfileRequest.newEmail.isNullOrEmpty()) updateProfile.email = changeProfileRequest.newEmail
        if (!changeProfileRequest.newPhone.isNullOrEmpty()) updateProfile.phone = changeProfileRequest.newPhone
        if (!changeProfileRequest.newAddress.isNullOrEmpty()) updateProfile.address =changeProfileRequest.newAddress

        userRepository.updateUsersById(changeProfileRequest.Id,updateProfile)

    }
}



