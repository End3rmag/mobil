package org.example.domein.Response

data class UserResponse (
    val Id: Int,
    var firstName: String,
    var lasnName: String? = null,
    var email: String,
    var phone:String? = null,
    var address:String? = null,
    var favouriteList: List<ShoesResponse> = emptyList()
)//s