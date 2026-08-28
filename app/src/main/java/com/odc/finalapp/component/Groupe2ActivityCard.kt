package com.odc.finalapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Groupe2ActivityCard(
    nombreVentes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFEEF4FF),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.TrendingUp,
            contentDescription = "Activité",
            tint = Color(0xFF356AE6)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "ACTIVITÉ DU JOUR",
                fontSize = 12.sp,
                color = Color(0xFF356AE6)
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "$nombreVentes ventes réalisées",
                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Votre activité commerciale aujourd'hui",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}