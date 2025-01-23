package org.example.data

import org.example.data.Model.UserDTO
import org.example.domein.Request.RegistrationRequest

class UserRepositoryImpl: UserRepository {
    private val userSource: MutableList<UserDTO> = userList.toMutableList()

    override fun addUsers(registrationRequest: RegistrationRequest): UserDTO {
        val user =  UserDTO(
            Id = userSource.size+1,
            email = registrationRequest.email,
            firstName = registrationRequest.firstName,
            password = registrationRequest.password
        )
        userSource.add(user)
        return user
    }




    override fun removeUsersById(Id: Int): Boolean {
       return userSource.removeIf { it.Id == Id }
    }

    override fun updateUsersById(Id: Int, updatedUser: UserDTO): UserDTO {
        val oldUser = userSource.firstOrNull(){it.Id == Id}
        checkNotNull(oldUser)
        oldUser.phone = updatedUser.phone
        oldUser.address = updatedUser.address
        oldUser.firstName = updatedUser.firstName
        oldUser.lasnName = updatedUser.lasnName
        oldUser.password = updatedUser.password
        oldUser.email  = updatedUser.email
        return oldUser
    }

    override fun getAllUsers(): List<UserDTO> = userSource

    override fun findUsersById(Id: Int): UserDTO {
        val findUsers = userSource.firstOrNull { it.Id == Id }
        checkNotNull(findUsers)
        return findUsers}
}

