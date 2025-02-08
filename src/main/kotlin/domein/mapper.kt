package org.example.domein

import org.example.data.Model.ShoesDTO
import org.example.data.Model.UserDTO
import org.example.domein.Response.ShoesResponse
import org.example.domein.Response.UserResponse

fun UserDTOToUserResponse(userDTO: UserDTO, shoesList: List<ShoesDTO> = emptyList()) = UserResponse(
    lasnName = userDTO.lasnName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    Id = userDTO.Id,
    address = userDTO.address,
    favouriteList = shoesList.map(::ShoesDTOToShoesResponse)
)

fun ShoesDTOToShoesResponse(shoesDTO: ShoesDTO) = ShoesResponse(
    shoesId = shoesDTO.shoesId,
    shoesName = shoesDTO.shoesName,
    shoesDescription = shoesDTO.shoesDescription.toString(),
    shoesUrl = shoesDTO.shoesURL,
    category = shoesDTO.cotegory
)
//s