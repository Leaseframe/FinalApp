package com.odc.finalapp.data

import com.odc.finalapp.Model.Client

object ClientRepository {

    private val clients = listOf(
        Client(1, "Diakité", "Th Abdoulaye", "622 91 74 53", "mdiallo@gmail.com", "Matam, Conakry", 0.0),
        Client(2, "Diaby", "Mahawa", "62X XX 55 XX", "fcamara@gmail.com", "Ratoma, Conakry", 150000.0),
        Client(3, "Bah", "Ibrahima", "655 77 88 99", "ibah@gmail.com", "Dixinn, Conakry", 0.0),
        Client(4, "Sylla", "Aissatou", "620 12 34 56", "asylla@gmail.com", "Kaloum, Conakry", 75000.0),
        Client(5, "Barry", "Ousmane", "664 98 76 54", "obarry@gmail.com", "Matoto, Conakry", 0.0)
    )

    fun getAll(): List<Client> = clients

    fun search(query: String): List<Client> {
        if (query.isBlank()) return clients
        return clients.filter {
            it.nom.contains(query, ignoreCase = true) ||
                    it.prenom.contains(query, ignoreCase = true) ||
                    it.telephone.contains(query)
        }
    }
}