package com.odc.finalapp.View

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odc.finalapp.ViewModel.StartViewModel


@Composable
fun AppNavigation() {
    val nC = rememberNavController()

    NavHost(
        navController = nC,
        startDestination = "start"
    ) {
        composable("start") {
            val vm: StartViewModel = viewModel()
            StartScreen(
                vm = vm,
                onNavigateToInscription = {
                    nC.navigate("inscription")
                },
                onNavigateToConnection = {
                    nC.navigate("connection")
                }
            )
        }

        composable("connection") {
            ConnectionScreen(
                onNavigateToHome = {
                    nC.navigate("home")
                }
            )
        }

        composable("inscription") {
            Inscription(
                onNavigateToHome = {
                    nC.navigate("home")
                }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}