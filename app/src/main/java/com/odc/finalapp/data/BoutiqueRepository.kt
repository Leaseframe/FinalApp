package com.odc.finalapp.data

import com.odc.finalapp.Model.BoutiqueProfil

object BoutiqueRepository {

    // Donnée statique simulant "la" boutique unique
    private var profil = BoutiqueProfil(
        nom = "Gestion Vente",
        proprietaire = "Th Abdoulaye Diakité",
        telephone = "622 91 74 53",
        email = "odc@gmail.gn",
        adresse = "Cyber",
        description = "Vente de pièces détachées, et accessoires"
    )

    fun getProfil(): BoutiqueProfil = profil

    fun updateProfil(nouveau: BoutiqueProfil) {
        profil = nouveau
    }
}