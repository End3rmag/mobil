package org.example.domein

import org.example.domein.Request.*
import org.example.domein.Response.UserResponse

interface UserUseCase {
    fun authorize(authorizeRequest: AuthorizeRequest):UserResponse
    fun registration(registrationRequest: RegistrationRequest):UserResponse
    fun changePassword(changePasswordRequest: ChangePasswordRequest)
    fun changeProfile(changeProfileRequest: ChangeProfileRequest)
}