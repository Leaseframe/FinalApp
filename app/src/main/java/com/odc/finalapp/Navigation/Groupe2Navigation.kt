package com.odc.finalapp.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odc.finalapp.View.BoutiqueProfilScreen
import com.odc.finalapp.View.ClientListScreen
import com.odc.finalapp.View.FournisseurListScreen
import com.odc.finalapp.View.Groupe2ClientScreen
import com.odc.finalapp.View.Groupe2FournisseurScreen
import com.odc.finalapp.View.Groupe2HomeScreen
import com.odc.finalapp.View.Groupe2ProfilScreen
import com.odc.finalapp.View.Groupe3Navigation
import com.odc.finalapp.View.HomeScreen

@Composable
fun Groupe2Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

//
//        composable("home") {
//            Groupe2HomeScreen(
//                onNavigate = { route ->
//                    navController.navigate(route)
//                }
//            )
//        }


        composable("clients") {
            //Groupe2ClientScreen()
            //ClientListScreen()
            Groupe3Navigation()
        }


        composable("fournisseurs") {
            //Groupe2FournisseurScreen()
            FournisseurListScreen()
        }
        composable("Stocks") {
            HomeScreen(
                onNavigateToStock = { navController.navigate("stock") },
                onNavigateToLivraison = { navController.navigate("livraison") }
            )
        }


        composable("profil") {
            //Groupe2ProfilScreen()
            BoutiqueProfilScreen()
        }
    }
}