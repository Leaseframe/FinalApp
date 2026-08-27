package com.odc.finalapp.ViewModel

import com.odc.finalapp.Model.Fournisseur
import com.odc.finalapp.data.FournisseurRepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FournisseurViewModel : ViewModel() {

    private val _fournisseurs = MutableStateFlow<List<Fournisseur>>(emptyList())
    val fournisseurs: StateFlow<List<Fournisseur>> = _fournisseurs.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        chargerFournisseurs()
    }

    private fun chargerFournisseurs() {
        viewModelScope.launch {
            _fournisseurs.value = FournisseurRepository.getAll()
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        _fournisseurs.value = FournisseurRepository.search(query)
    }
}