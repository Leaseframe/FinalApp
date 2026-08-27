package com.odc.finalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.odc.finalapp.Navigation.Groupe2Navigation
import com.odc.finalapp.ui.theme.FinalAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            FinalAppTheme {
                Groupe2Navigation()
            }
        }
    }
}