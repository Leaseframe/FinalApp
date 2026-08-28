package com.odc.finalapp.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.odc.finalapp.Model.Livraison
import kotlinx.coroutines.flow.Flow

@Dao
interface LivraisonDao {

    @Insert
    suspend fun insertLivraison(livraison: Livraison)

    @Update
    suspend fun updateLivraison(livraison: Livraison)

    @Delete
    suspend fun deleteLivraison(livraison: Livraison)

    @Query("SELECT * FROM livraisons ORDER BY id DESC")
    fun getAllLivraisons(): Flow<List<Livraison>>

    @Query("UPDATE livraisons SET status = :newStatus WHERE id = :id")
    suspend fun updateStatus(id: Int, newStatus: String)
}
