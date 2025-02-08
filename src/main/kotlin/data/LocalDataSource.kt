package org.example.data

import org.example.data.Model.FavouriteDTO
import org.example.data.Model.ShoesDTO
import org.example.data.Model.UserDTO

val shoesList = listOf(
    ShoesDTO(
        shoesId = 1,
        shoesName = "Nike",
        shoesDescription = "dasgasdgsdagsdafd",
        shoesURL = "3",
        cotegory = "1"
    ),
    ShoesDTO(
        shoesId = 2,
        shoesName = "Abibas",
        shoesDescription = "das",
        shoesURL = "5",
        cotegory = "123"
    )

)

val favouriteList = listOf(
    FavouriteDTO(
        1,
        1
    ),
    FavouriteDTO(
        2,
        2
    )
)



val userList = listOf(
    UserDTO(
        Id =1,
        firstName ="Viva",
        password = "123",
        email = "123"

    ),
    UserDTO(
        Id = 2,
        firstName = "Kate",
        password = "456",
        email = "456"
    ),
    UserDTO(
        Id = 3,
        firstName = "Max",
        password = "789",
        email = "oniujsadfghb@mail.ru"
    ),
)