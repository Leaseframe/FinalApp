package com.odc.finalapp

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
<<<<<<< HEAD
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
<<<<<<< HEAD
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.odc.finalapp.View.AppNavigation
import com.odc.finalapp.View.Inscription
import com.odc.finalapp.View.StartScreen
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

        setContent {
<<<<<<< HEAD
            FinalAppTheme {
<<<<<<< HEAD
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    AppNavigation()
                    //Inscription()

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
            }
        }
    }
}
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
