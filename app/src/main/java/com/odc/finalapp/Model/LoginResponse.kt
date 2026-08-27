package com.odc.finalapp.Model

data class LoginResponse(
    val users: Users?,
    val success: Boolean,
    val message: String
)
