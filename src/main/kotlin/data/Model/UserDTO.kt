package org.example.data.Model

data class UserDTO(
    val Id: Int,
    var firstName: String,
    var lasnName: String? = null,
    var password: String,
    var email: String,
    var phone:String? = null,
    var address:String? = null
)
