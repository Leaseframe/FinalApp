package com.odc.finalapp.data

import com.odc.finalapp.Model.Fournisseur

object FournisseurRepository {

    private val fournisseurs = listOf(
        Fournisseur(
            1,
            "Sonfonia Import",
            "622 10 20 30",
            "sonfonia@import.com",
            "Sonfonia, Conakry",
            "Pneus",
            500000.0
        ),
        Fournisseur(2, "Guinée Moto Pièces", "628 40 50 60", "contact@gmp.com", "Matam, Conakry", "Pièces moteur", 0.0),
        Fournisseur(3, "AutoLub Guinée", "655 70 80 90", "autolub@gmail.com", "Ratoma, Conakry", "Huiles & lubrifiants", 120000.0),
        Fournisseur(4, "Sahel Distribution", "620 11 22 33", "sahel.dist@gmail.com", "Kaloum, Conakry", "Accessoires", 0.0),
        Fournisseur(5, "Express Pneus SA", "664 99 88 77", "expresspneus@gmail.com", "Dixinn, Conakry", "Pneus", 300000.0)
    )

    fun getAll(): List<Fournisseur> = fournisseurs

    fun search(query: String): List<Fournisseur> {
        if (query.isBlank()) return fournisseurs
        return fournisseurs.filter {
            it.nom.contains(query, ignoreCase = true) ||
                    it.categorieProduits.contains(query, ignoreCase = true) ||
                    it.telephone.contains(query)
        }
    }
}