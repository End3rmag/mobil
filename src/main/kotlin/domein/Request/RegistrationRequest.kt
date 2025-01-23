package org.example.domein.Request

data class RegistrationRequest (
    val email: String,
    val password:  String,
    val firstName: String
)