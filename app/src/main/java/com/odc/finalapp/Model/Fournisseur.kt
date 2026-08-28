package com.odc.finalapp.Model

data class Fournisseur(
    val id: Int,
    val nom: String,
    val telephone: String,
    val email: String,
    val adresse: String,
    val categorieProduits: String, // ex: "Pneus", "Pièces moteur", "Huiles & lubrifiants"
    val dette: Double = 0.0 // montant qu'on doit encore à ce fournisseur
)