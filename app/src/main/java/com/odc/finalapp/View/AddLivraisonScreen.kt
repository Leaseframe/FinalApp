package com.odc.finalapp.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.odc.finalapp.Model.Produit
import com.odc.finalapp.ViewModel.LivraisonViewModel
import com.odc.finalapp.ViewModel.StockViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddLivraisonScreen(
    livraisonViewModel: LivraisonViewModel,
    stockViewModel: StockViewModel,
    onNavigateBack: () -> Unit
) {
    var clientName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    
    var selectedProduit by remember { mutableStateOf<Produit?>(null) }
    var quantity by remember { mutableStateOf("1") }
    var deliveryFee by remember { mutableStateOf("0") }
    
    val produits by stockViewModel.produits.collectAsState(initial = emptyList())
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    var date by remember { mutableStateOf(sdf.format(Date())) }

    // Automatisation : calcul du montant total
    val unitPrice = selectedProduit?.prix ?: 0.0
    val totalAmount = (unitPrice * (quantity.toIntOrNull() ?: 0))
    
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Nouvelle Livraison", color = Color.White, fontWeight = FontWeight.Bold) },
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Informations Client", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            
            OutlinedTextField(
                value = clientName,
                onValueChange = { clientName = it },
                label = { Text("Nom du client") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Téléphone") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Adresse de livraison") },
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Text("Détails Commande", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)

            // Automatisation : Menu déroulant pour les produits
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = selectedProduit?.nom ?: "Sélectionner un produit",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Produit") },
                    leadingIcon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    produits.forEach { produit ->
                        DropdownMenuItem(
                            text = { Text("${produit.nom} (${produit.prix} GNF)") },
                            onClick = {
                                selectedProduit = produit
                                expanded = false
                            }
                        )
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantité") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = deliveryFee,
                    onValueChange = { deliveryFee = it },
                    label = { Text("Frais Livr.") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f)
                )
            }

            // Affichage automatique du montant
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Total à payer : ${totalAmount + (deliveryFee.toDoubleOrNull() ?: 0.0)} GNF", style = MaterialTheme.typography.titleLarge)
                    Text("Dont Frais : $deliveryFee GNF", style = MaterialTheme.typography.bodyMedium)
                }
            }

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date") },
                leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val q = quantity.toIntOrNull() ?: 0
                    val f = deliveryFee.toDoubleOrNull() ?: 0.0
                    val p = selectedProduit

                    if (clientName.isNotBlank() && phone.isNotBlank() && p != null && q > 0) {
                        // Enregistrement
                        livraisonViewModel.ajouterLivraison(
                            clientName, phone, address, p.nom, q, totalAmount, f, date
                        )
                        // Automatisation : Mise à jour du stock
                        stockViewModel.mettreAJourQuantite(p.id, q)
                        
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp)
            ) {
                Icon(Icons.Default.Check, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("VALIDER LA LIVRAISON")
            }
        }
    }
}
