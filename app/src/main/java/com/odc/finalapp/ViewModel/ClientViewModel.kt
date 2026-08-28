package com.odc.finalapp.ViewModel

import androidx.lifecycle.ViewModel
import com.odc.finalapp.Model.Client
import com.odc.finalapp.data.ClientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ClientViewModel : ViewModel() {

    private val _clients = MutableStateFlow<List<Client>>(emptyList())
    val clients: StateFlow<List<Client>> = _clients.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        chargerClients()
    }

    private fun chargerClients() {
        viewModelScope.launch {
            _clients.value = ClientRepository.getAll()
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        _clients.value = ClientRepository.search(query)
    }
}