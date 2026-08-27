package com.odc.finalapp.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.odc.finalapp.Model.Produit
import kotlinx.coroutines.flow.Flow

@Dao
interface ProduitDao {

    @Insert
    suspend fun ajouterProduit(produit: Produit)

    @Update
    suspend fun modifierProduit(produit: Produit)

    @Delete
    suspend fun supprimerProduit(produit: Produit)

    @Query("SELECT * FROM produits ORDER BY id DESC")
    fun obtenirProduits(): Flow<List<Produit>>

    @Query("SELECT * FROM produits WHERE id = :id")
    suspend fun obtenirProduit(id: Int): Produit?

    @Query("DELETE FROM produits")
    suspend fun supprimerTousLesProduits()
}