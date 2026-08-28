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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            FinalAppTheme {
<<<<<<< HEAD
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    AppNavigation()
                    //Inscription()

                }
            }
        }
    }
}

=======
                Groupe2Navigation()
            }
        }
    }
}
>>>>>>> origin/Groupe2
