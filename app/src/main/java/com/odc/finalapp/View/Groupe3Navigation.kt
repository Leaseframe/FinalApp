package com.odc.finalapp.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.odc.finalapp.AppGroup4
import com.odc.finalapp.StartGroup4

@Composable
fun Groupe3Navigation() {

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
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Home")
                    }
                )
                NavigationBarItem(
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
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
                    selected = selectedItem == 2,
                    onClick = {
                        selectedItem = 2
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
                    selected = selectedItem == 3,

                    onClick = {
                        selectedItem = 3
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
                NavigationBarItem(
                    selected = selectedItem == 4,

                    onClick = {
                        selectedItem = 4
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Store,
                            contentDescription = "Stock"
                        )
                    },
                    label = {
                        Text("Stock")
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
                0 -> Groupe2HomeScreen()
                1 -> ClientListScreen()
                2 -> FournisseurListScreen()
                3 -> BoutiqueProfilScreen()
                4 -> AppGroup4()
            }
        }
    }
}


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