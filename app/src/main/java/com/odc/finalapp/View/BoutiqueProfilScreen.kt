package com.odc.finalapp.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odc.finalapp.ViewModel.BoutiqueViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoutiqueProfilScreen(
    viewModel: BoutiqueViewModel = viewModel()
) {
    val profil by viewModel.profil.collectAsState()
    val isEditing by viewModel.isEditing.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profil Boutique", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6A1B9A),
                    titleContentColor = Color.White
                ),
                actions = {
                    if (!isEditing) {
                        IconButton(onClick = { viewModel.demarrerEdition() }) {
                            Icon(Icons.Default.Edit, contentDescription = "Modifier", tint = Color.White)
                        }
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // En-tête avec icône boutique
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF6A1B9A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Store,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    if (!isEditing) {
                        Text(
                            text = profil.nom,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (isEditing) {
                FormulaireEdition(viewModel)
            } else {
                AffichageProfil(profil)
            }
        }
    }
}

@Composable
private fun AffichageProfil(profil: com.odc.finalapp.Model.BoutiqueProfil) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            InfoRow(Icons.Default.Person, "Propriétaire", profil.proprietaire)
            InfoDivider()
            InfoRow(Icons.Default.Phone, "Téléphone", profil.telephone)
            InfoDivider()
            InfoRow(Icons.Default.Email, "Email", profil.email)
            InfoDivider()
            InfoRow(Icons.Default.LocationOn, "Adresse", profil.adresse)
            InfoDivider()
            InfoRow(Icons.Default.Description, "Description", profil.description)
        }
    }
}

@Composable
private fun InfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF6A1B9A), modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(label, fontSize = 12.sp, color = Color.Gray)
            Text(value, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun InfoDivider() {
    Spacer(modifier = Modifier.height(12.dp))
    HorizontalDivider(color = Color(0xFFEEEEEE))
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
private fun FormulaireEdition(viewModel: BoutiqueViewModel) {
    val nom by viewModel.formNom.collectAsState()
    val proprietaire by viewModel.formProprietaire.collectAsState()
    val telephone by viewModel.formTelephone.collectAsState()
    val email by viewModel.formEmail.collectAsState()
    val adresse by viewModel.formAdresse.collectAsState()
    val description by viewModel.formDescription.collectAsState()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nom,
                onValueChange = { viewModel.onNomChange(it) },
                label = { Text("Nom boutique") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = proprietaire,
                onValueChange = { viewModel.onProprietaireChange(it) },
                label = { Text("Propriétaire") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = telephone,
                onValueChange = { viewModel.onTelephoneChange(it) },
                label = { Text("Téléphone") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = adresse,
                onValueChange = { viewModel.onAdresseChange(it) },
                label = { Text("Adresse") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { viewModel.onDescriptionChange(it) },
                label = { Text("Description") },
                minLines = 3,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { viewModel.annulerEdition() },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Annuler")
                }
                Button(
                    onClick = { viewModel.enregistrer() },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A))
                ) {
                    Text("Enregistrer")
                }
            }
        }
    }
}