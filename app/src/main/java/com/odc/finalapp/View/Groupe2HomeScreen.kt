package com.odc.finalapp.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odc.finalapp.Components.Groupe2ActivityCard
import com.odc.finalapp.Components.Groupe2BottomBar
import com.odc.finalapp.Components.Groupe2DashboardCard
import com.odc.finalapp.Components.Groupe2ShopHeader
import com.odc.finalapp.ViewModel.Groupe2HomeViewModel

@Composable
fun Groupe2HomeScreen(
//    onNavigate: (String) -> Unit,
    viewModel: Groupe2HomeViewModel = viewModel()
) {
    val dashboard by viewModel.dashboard.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp
                )
        ) {

            Groupe2ShopHeader(
                nomBoutique = dashboard.nomBoutique
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Text(
                text = "Bonjour 👋",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Voici un aperçu de votre activité",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(
                    alpha = 0.6f
                )
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Groupe2ActivityCard(
                nombreVentes = dashboard.nombreVentes
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Text(
                text = "Aperçu de l'activité",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Groupe2DashboardCard(
                    title = "Produits",
                    value = dashboard.nombreProduits.toString(),
                    subtitle = "produits",
                    modifier = Modifier.weight(1f)
                )

                Groupe2DashboardCard(
                    title = "Ventes",
                    value = dashboard.nombreVentes.toString(),
                    subtitle = "ventes",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Groupe2DashboardCard(
                    title = "Chiffre d'affaires",
                    value = "${dashboard.chiffreAffaires} GNF",
                    subtitle = "CA",
                    modifier = Modifier.weight(1f)
                )

                Groupe2DashboardCard(
                    title = "Stock",
                    value = dashboard.stock.toString(),
                    subtitle = "unités",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
        }

//        Groupe2BottomBar(
//            currentRoute = "home",
//            onNavigate = onNavigate
//        )
    }
}