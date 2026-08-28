package com.odc.finalapp

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
<<<<<<< HEAD
<<<<<<< HEAD
=======
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
>>>>>>> origin/groupe4
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
<<<<<<< HEAD
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.odc.finalapp.View.BoutiqueProfilScreen
import com.odc.finalapp.View.ClientListScreen
import com.odc.finalapp.View.FournisseurListScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
=======
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
>>>>>>> origin/groupe4
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
<<<<<<< HEAD
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.odc.finalapp.View.AppNavigation
import com.odc.finalapp.View.Inscription
import com.odc.finalapp.View.StartScreen
=======
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
>>>>>>> origin/groupe4
import com.odc.finalapp.ui.theme.FinalAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
=======
import com.odc.finalapp.Navigation.Groupe2Navigation
import com.odc.finalapp.ui.theme.FinalAppTheme

class MainActivity : ComponentActivity() {

>>>>>>> origin/Groupe2
=======
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

>>>>>>> origin/group3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
<<<<<<< HEAD
=======
        
        val database = AppDatabase.getDatabase(this)
        val produitDao = database.produitDao()
        val livraisonDao = database.livraisonDao()
>>>>>>> origin/groupe4

        setContent {
<<<<<<< HEAD
            FinalAppTheme {
<<<<<<< HEAD
<<<<<<< HEAD
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    AppNavigation()
                    //Inscription()

=======
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
>>>>>>> origin/groupe4
                }
=======
            FinalApp {
                AppNavigation()
>>>>>>> origin/group3
            }
        }
    }
}

<<<<<<< HEAD
=======
                Groupe2Navigation()
=======
@Composable
<<<<<<< HEAD
fun AppNavigation() {

    var selectedItem by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.People,
                            contentDescription = "Clients"
                        )
                    },
                    label = {
                        Text("Clients")
                    }
                )
                NavigationBarItem(
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Fournisseurs"
                        )
                    },
                    label = {
                        Text("Fournisseurs")
                    }
                )
                NavigationBarItem(
                    selected = selectedItem == 2,

                    onClick = {
                        selectedItem = 2
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Business,
                            contentDescription = "Boutique"
                        )
                    },
                    label = {
                        Text("Boutique")
                    }
                )
            }
        }

    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (selectedItem) {
                0 -> ClientListScreen()
                1 -> FournisseurListScreen()
                2 -> BoutiqueProfilScreen()
>>>>>>> origin/group3
=======
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
>>>>>>> origin/groupe4
            }
        }
    }
}
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/Groupe2
=======


@Composable
fun FinalApp(content: @Composable () -> Unit) {

    val colorScheme = lightColorScheme(
        primary = Color(0xFF1565C0),
        secondary = Color(0xFF1976D2),
        background = Color(0xFFF5F6FA),
        surface = Color.White
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
>>>>>>> origin/group3
=======
>>>>>>> origin/groupe4
