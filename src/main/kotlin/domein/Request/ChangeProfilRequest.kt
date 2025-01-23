package org.example.domein.Request

data class ChangeProfileRequest (
    val Id: Int,
    val newFirstName: String?,
    val newLastName: String?,
    val newEmail: String?,
    val newPhone: String?,
    val newAddress: String?,
)