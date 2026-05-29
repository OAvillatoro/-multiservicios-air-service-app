package com.multiserviciosoriente.airserviceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.multiserviciosoriente.airserviceapp.presentation.navigation.AppNavigation
import com.multiserviciosoriente.airserviceapp.ui.theme.AirServiceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AirServiceAppTheme {
                AppNavigation()
            }
        }
    }
}