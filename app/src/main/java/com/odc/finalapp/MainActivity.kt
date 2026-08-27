package com.odc.finalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import com.odc.finalapp.ui.theme.HomeGradientEnd
import com.odc.finalapp.ui.theme.HomeGradientStart
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odc.finalapp.Database.AppDatabase
import com.odc.finalapp.View.AddLivraisonScreen
import com.odc.finalapp.View.AddProductScreen
import com.odc.finalapp.View.LivraisonScreen
import com.odc.finalapp.View.StockScreen
import com.odc.finalapp.ViewModel.LivraisonViewModel
import com.odc.finalapp.ViewModel.StockViewModel
import com.odc.finalapp.ui.theme.FinalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val database = AppDatabase.getDatabase(this)
        val produitDao = database.produitDao()
        val livraisonDao = database.livraisonDao()

        setContent {
            FinalAppTheme {
                val navController = rememberNavController()
                
                val stockViewModel: StockViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            @Suppress("UNCHECKED_CAST")
                            return StockViewModel(produitDao) as T
                        }
                    }
                )

                val livraisonViewModel: LivraisonViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            @Suppress("UNCHECKED_CAST")
                            return LivraisonViewModel(livraisonDao) as T
                        }
                    }
                )

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onNavigateToStock = { navController.navigate("stock") },
                            onNavigateToLivraison = { navController.navigate("livraison") }
                        )
                    }
                    composable("stock") {
                        StockScreen(
                            viewModel = stockViewModel,
                            onAddProduct = { navController.navigate("add_product") },
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("add_product") {
                        AddProductScreen(
                            viewModel = stockViewModel,
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("livraison") {
                        LivraisonScreen(
                            viewModel = livraisonViewModel,
                            onAddLivraison = { navController.navigate("add_livraison") },
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable("add_livraison") {
                        AddLivraisonScreen(
                            livraisonViewModel = livraisonViewModel,
                            stockViewModel = stockViewModel,
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    onNavigateToStock: () -> Unit,
    onNavigateToLivraison: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(HomeGradientStart, HomeGradientEnd)
                )
            )
    ) {
        Scaffold(
            containerColor = Color.Transparent // Pour laisser voir le dégradé
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = Color.White
                )
                
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "MA BOUTIQUE",
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "Système de Gestion Premium",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                Card(
                    onClick = onNavigateToStock,
                    modifier = Modifier.fillMaxWidth().height(140.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = HomeGradientStart.copy(alpha = 0.2f),
                            modifier = Modifier.size(60.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Inventory, contentDescription = null, modifier = Modifier.size(32.dp), tint = HomeGradientStart)
                            }
                        }
                        Column {
                            Text("Gestion du Stock", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                            Text("Inventaire et produits", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
                
                Card(
                    onClick = onNavigateToLivraison,
                    modifier = Modifier.fillMaxWidth().height(140.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = HomeGradientEnd.copy(alpha = 0.2f),
                            modifier = Modifier.size(60.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.LocalShipping, contentDescription = null, modifier = Modifier.size(32.dp), tint = HomeGradientEnd)
                            }
                        }
                        Column {
                            Text("Livraisons", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                            Text("Suivi des commandes client", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
