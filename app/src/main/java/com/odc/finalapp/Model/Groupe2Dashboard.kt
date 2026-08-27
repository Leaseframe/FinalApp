package com.odc.finalapp.Model

data class Groupe2Dashboard(
    val nomBoutique: String,
    val logo: String? = null,
    val nombreProduits: Int,
    val nombreVentes: Int,
    val chiffreAffaires: Double,
    val stock: Int
)
