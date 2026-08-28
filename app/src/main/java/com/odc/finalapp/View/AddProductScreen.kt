package com.odc.finalapp.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.odc.finalapp.ViewModel.StockViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    viewModel: StockViewModel,
    onNavigateBack: () -> Unit
) {
    var nom by remember { mutableStateOf("") }
    var categorie by remember { mutableStateOf("") }
    var prix by remember { mutableStateOf("") }
    var quantite by remember { mutableStateOf("") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Ajouter un produit", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = nom,
                onValueChange = { nom = it },
                label = { Text("Nom du produit") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = categorie,
                onValueChange = { categorie = it },
                label = { Text("Catégorie") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = prix,
                onValueChange = { prix = it },
                label = { Text("Prix") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = quantite,
                onValueChange = { quantite = it },
                label = { Text("Quantité") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val p = prix.toDoubleOrNull() ?: 0.0
                    val q = quantite.toIntOrNull() ?: 0
                    if (nom.isNotBlank() && categorie.isNotBlank() && q > 0) {
                        viewModel.ajouterProduit(nom, categorie, p, q)
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENREGISTRER LE PRODUIT")
            }
        }
    }
}
