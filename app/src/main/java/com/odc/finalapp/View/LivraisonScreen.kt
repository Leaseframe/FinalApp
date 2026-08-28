package com.odc.finalapp.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odc.finalapp.Model.Livraison
import com.odc.finalapp.ViewModel.LivraisonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LivraisonScreen(
    viewModel: LivraisonViewModel,
    onAddLivraison: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val livraisons by viewModel.livraisons.collectAsState(initial = emptyList())

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Suivi des Livraisons", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddLivraison,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        }
    ) { padding ->
        if (livraisons.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(64.dp), tint = Color.LightGray)
                    Spacer(Modifier.height(8.dp))
                    Text("Aucune livraison en cours", color = Color.Gray)
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(padding).fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(livraisons) { livraison ->
                    LivraisonItem(
                        livraison = livraison,
                        onDelete = { viewModel.supprimerLivraison(livraison) },
                        onStatusChange = { newStatus ->
                            viewModel.changerStatut(livraison.id, newStatus)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LivraisonItem(
    livraison: Livraison,
    onDelete: () -> Unit,
    onStatusChange: (String) -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }
    val statuses = listOf("En attente", "En préparation", "En cours", "Livrée", "Annulée")

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = livraison.clientName,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(14.dp), tint = Color.Gray)
                        Spacer(Modifier.width(4.dp))
                        Text(livraison.phone, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    }
                }
                
                Surface(
                    color = getStatusColor(livraison.status).copy(alpha = 0.1f),
                    modifier = Modifier.clip(CircleShape)
                ) {
                    TextButton(onClick = { showMenu = true }) {
                        Text(
                            text = livraison.status,
                            color = getStatusColor(livraison.status),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                    statuses.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = {
                                onStatusChange(status)
                                showMenu = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("PRODUIT", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text(livraison.productName, fontWeight = FontWeight.Medium)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("QUANTITÉ", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text("x${livraison.quantity}", fontWeight = FontWeight.Medium)
                }
            }

            Spacer(Modifier.height(8.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Gray)
                Spacer(Modifier.width(4.dp))
                Text(livraison.address, style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("TOTAL À RECEVOIR", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text(
                        "${livraison.amount + livraison.deliveryFee} GNF",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.background(Color.Red.copy(alpha = 0.1f), CircleShape)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Supprimer", tint = Color.Red, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

fun getStatusColor(status: String): Color {
    return when (status) {
        "En attente" -> Color(0xFF757575)
        "En préparation" -> Color(0xFF1976D2)
        "En cours" -> Color(0xFFFFA000)
        "Livrée" -> Color(0xFF388E3C)
        "Annulée" -> Color(0xFFD32F2F)
        else -> Color.Black
    }
}
