package org.example.data

import org.example.data.Model.UserDTO
import org.example.domein.Request.RegistrationRequest

interface UserRepository {
    fun addUsers (registrationRequest: RegistrationRequest):UserDTO
    fun removeUsersById(Id: Int): Boolean
    fun updateUsersById(Id: Int, updatedUser: UserDTO): UserDTO
    fun getAllUsers(): List<UserDTO>
    fun findUsersById(Id: Int):UserDTO
}