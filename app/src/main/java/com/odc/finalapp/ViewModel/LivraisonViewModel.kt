package com.odc.finalapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odc.finalapp.Database.LivraisonDao
import com.odc.finalapp.Model.Livraison
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LivraisonViewModel(
    private val livraisonDao: LivraisonDao
) : ViewModel() {

    val livraisons: Flow<List<Livraison>> = livraisonDao.getAllLivraisons()

    fun ajouterLivraison(
        clientName: String,
        phone: String,
        address: String,
        productName: String,
        quantity: Int,
        amount: Double,
        deliveryFee: Double,
        date: String
    ) {
        viewModelScope.launch {
            val livraison = Livraison(
                clientName = clientName,
                phone = phone,
                address = address,
                productName = productName,
                quantity = quantity,
                amount = amount,
                deliveryFee = deliveryFee,
                date = date
            )
            livraisonDao.insertLivraison(livraison)
        }
    }

    fun modifierLivraison(livraison: Livraison) {
        viewModelScope.launch {
            livraisonDao.updateLivraison(livraison)
        }
    }

    fun supprimerLivraison(livraison: Livraison) {
        viewModelScope.launch {
            livraisonDao.deleteLivraison(livraison)
        }
    }

    fun changerStatut(id: Int, nouveauStatut: String) {
        viewModelScope.launch {
            livraisonDao.updateStatus(id, nouveauStatut)
        }
    }
}
