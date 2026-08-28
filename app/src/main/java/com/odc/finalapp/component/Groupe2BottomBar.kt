package com.odc.finalapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Groupe2BottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                horizontal = 8.dp,
                vertical = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Groupe2BottomBarItem(
            modifier = Modifier.weight(1f),
            selected = currentRoute == "home",
            icon = Icons.Default.Home,
            label = "Accueil",
            onClick = {
                onNavigate("home")
            }
        )

        Groupe2BottomBarItem(
            modifier = Modifier.weight(1f),
            selected = currentRoute == "clients",
            icon = Icons.Default.People,
            label = "Clients",
            onClick = {
                onNavigate("clients")
            }
        )

        Groupe2BottomBarItem(
            modifier = Modifier.weight(1f),
            selected = currentRoute == "fournisseurs",
            icon = Icons.Default.Business,
            label = "Fournisseurs",
            onClick = {
                onNavigate("fournisseurs")
            }
        )

        Groupe2BottomBarItem(
            modifier = Modifier.weight(1f),
            selected = currentRoute == "profil",
            icon = Icons.Default.Person,
            label = "Profil",
            onClick = {
                onNavigate("profil")
            }
        )
    }
}

@Composable
private fun Groupe2BottomBarItem(
    modifier: Modifier,
    selected: Boolean,
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable(
                onClick = onClick
            )
            .padding(vertical = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier
                .background(
                    color = if (selected) {
                        Color(0xFFEAF0FF)
                    } else {
                        Color.Transparent
                    },
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 6.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(22.dp),
                tint = if (selected) {
                    Color(0xFF356AE6)
                } else {
                    Color(0xFF8A93A3)
                }
            )

            Text(
                text = label,
                fontSize = 11.sp,
                color = if (selected) {
                    Color(0xFF356AE6)
                } else {
                    Color(0xFF8A93A3)
                }
            )
        }
    }
}