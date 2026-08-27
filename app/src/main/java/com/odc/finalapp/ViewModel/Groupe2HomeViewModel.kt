package com.odc.finalapp.ViewModel

import androidx.lifecycle.ViewModel
import com.odc.finalapp.Model.Groupe2Dashboard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Groupe2HomeViewModel : ViewModel() {

    private val _dashboard = MutableStateFlow(
        Groupe2Dashboard(
            nomBoutique = "Ma Boutique",
            logo = null,
            nombreProduits = 128,
            nombreVentes = 42,
            chiffreAffaires = 2450000.0,
            stock = 356
        )
    )

    val dashboard: StateFlow<Groupe2Dashboard> =
        _dashboard.asStateFlow()
}