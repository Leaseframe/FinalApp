package com.odc.finalapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odc.finalapp.View.Groupe2ClientScreen
import com.odc.finalapp.View.Groupe2FournisseurScreen
import com.odc.finalapp.View.Groupe2HomeScreen
import com.odc.finalapp.View.Groupe2ProfilScreen

@Composable
fun Groupe2Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {


        composable("home") {
            Groupe2HomeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }


        composable("clients") {
            Groupe2ClientScreen()
        }


        composable("fournisseurs") {
            Groupe2FournisseurScreen()
        }


        composable("profil") {
            Groupe2ProfilScreen()
        }
    }
}