package com.odc.finalapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odc.finalapp.Database.ProduitDao
import com.odc.finalapp.Model.Produit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class StockViewModel(
    private val produitDao: ProduitDao
) : ViewModel() {

    val produits: Flow<List<Produit>> =
        produitDao.obtenirProduits()

    fun ajouterProduit(
        nom: String,
        categorie: String,
        prix: Double,
        quantite: Int
    ) {
        viewModelScope.launch {

            val produit = Produit(
                nom = nom,
                categorie = categorie,
                prix = prix,
                quantite = quantite
            )

            produitDao.ajouterProduit(produit)
        }
    }

    fun modifierProduit(produit: Produit) {
        viewModelScope.launch {
            produitDao.modifierProduit(produit)
        }
    }

    fun supprimerProduit(produit: Produit) {
        viewModelScope.launch {
            produitDao.supprimerProduit(produit)
        }
    }

    fun mettreAJourQuantite(produitId: Int, quantiteVendue: Int) {
        viewModelScope.launch {
            val produit = produitDao.obtenirProduit(produitId)
            if (produit != null && produit.quantite >= quantiteVendue) {
                val nouveauProduit = produit.copy(quantite = produit.quantite - quantiteVendue)
                produitDao.modifierProduit(nouveauProduit)
            }
        }
    }
}
