package com.pdm0126.labo03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Home
            ) {
                composable<Home> {
                    HomeScreen(
                        onNavigateToNames = { navController.navigate(ListName) },
                        onNavigateToSensors = { navController.navigate(SensorDetail) }
                    )
                }
                composable<ListName> {
                    FormularioNombres()
                }
                composable<SensorDetail> {
                    LightSensor()
                }
            }
        }
    }
}

@Serializable
data object Home

@Serializable
data object ListName

@Serializable
data object SensorDetail
