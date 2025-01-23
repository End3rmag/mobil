package org.example.domein

import org.example.data.Model.UserDTO
import org.example.domein.Response.UserResponse

fun UserDTOToUserResponse(userDTO: UserDTO) = UserResponse(
    lasnName = userDTO.lasnName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    Id = userDTO.Id,
    address = userDTO.address,

)