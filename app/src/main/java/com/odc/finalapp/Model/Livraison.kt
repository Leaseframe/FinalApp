package com.odc.finalapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livraisons")
data class Livraison(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val clientName: String,
    val phone: String,
    val address: String,
    val productName: String,
    val quantity: Int,
    val amount: Double,
    val deliveryFee: Double,
    val date: String,
    val status: String = "En attente"
)
