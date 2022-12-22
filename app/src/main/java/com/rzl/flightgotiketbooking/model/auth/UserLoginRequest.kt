package com.rzl.flightgotiketbooking.model.auth

data class UserLoginRequest(
val email :String,
val password : String
)

data class LoginGoogle (
    val credential : String
)
