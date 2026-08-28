package com.odc.finalapp.Model

data class Client(
    val id: Int,
    val nom: String,
    val prenom: String,
    val telephone: String,
    val email: String,
    val adresse: String,
    val soldeCredit: Double = 0.0 // montant qu'il doit encore, si applicable
)