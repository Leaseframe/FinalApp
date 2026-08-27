package com.odc.finalapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Groupe2DashboardCard(
    title: String,
    value: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    val icon = when (title) {
        "Produits" -> Icons.Default.Inventory2
        "Ventes" -> Icons.Default.ShoppingCart
        "Chiffre d'affaires" -> Icons.Default.Payments
        "Stock" -> Icons.Default.Business
        else -> Icons.Default.Inventory2
    }

    Column(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = title,
                fontSize = 13.sp,
                color = Color(0xFF667085)
            )

            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(38.dp)
                    .background(
                        color = Color(0xFFEAF0FF),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(9.dp),
                tint = Color(0xFF356AE6)
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = value,
            fontSize = 23.sp,
            color = Color(0xFF172033)
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = subtitle,
            fontSize = 12.sp,
            color = Color(0xFF98A2B3)
        )
    }
}