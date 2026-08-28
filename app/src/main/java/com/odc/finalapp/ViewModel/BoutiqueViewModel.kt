package com.odc.finalapp.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odc.finalapp.Model.BoutiqueProfil
import com.odc.finalapp.data.BoutiqueRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BoutiqueViewModel : ViewModel() {

    private val _profil = MutableStateFlow(BoutiqueRepository.getProfil())
    val profil: StateFlow<BoutiqueProfil> = _profil.asStateFlow()

    private val _isEditing = MutableStateFlow(false)
    val isEditing: StateFlow<Boolean> = _isEditing.asStateFlow()

    // Champs temporaires pour le formulaire d'édition
    private val _formNom = MutableStateFlow("")
    val formNom: StateFlow<String> = _formNom.asStateFlow()

    private val _formProprietaire = MutableStateFlow("")
    val formProprietaire: StateFlow<String> = _formProprietaire.asStateFlow()

    private val _formTelephone = MutableStateFlow("")
    val formTelephone: StateFlow<String> = _formTelephone.asStateFlow()

    private val _formEmail = MutableStateFlow("")
    val formEmail: StateFlow<String> = _formEmail.asStateFlow()

    private val _formAdresse = MutableStateFlow("")
    val formAdresse: StateFlow<String> = _formAdresse.asStateFlow()

    private val _formDescription = MutableStateFlow("")
    val formDescription: StateFlow<String> = _formDescription.asStateFlow()

    fun onNomChange(v: String) { _formNom.value = v }
    fun onProprietaireChange(v: String) { _formProprietaire.value = v }
    fun onTelephoneChange(v: String) { _formTelephone.value = v }
    fun onEmailChange(v: String) { _formEmail.value = v }
    fun onAdresseChange(v: String) { _formAdresse.value = v }
    fun onDescriptionChange(v: String) { _formDescription.value = v }

    fun demarrerEdition() {
        val p = _profil.value
        _formNom.value = p.nom
        _formProprietaire.value = p.proprietaire
        _formTelephone.value = p.telephone
        _formEmail.value = p.email
        _formAdresse.value = p.adresse
        _formDescription.value = p.description
        _isEditing.value = true
    }

    fun annulerEdition() {
        _isEditing.value = false
    }

    fun enregistrer() {
        viewModelScope.launch {
            val nouveauProfil = BoutiqueProfil(
                nom = _formNom.value,
                proprietaire = _formProprietaire.value,
                telephone = _formTelephone.value,
                email = _formEmail.value,
                adresse = _formAdresse.value,
                description = _formDescription.value
            )
            BoutiqueRepository.updateProfil(nouveauProfil)
            _profil.value = nouveauProfil
            _isEditing.value = false
        }
    }
}