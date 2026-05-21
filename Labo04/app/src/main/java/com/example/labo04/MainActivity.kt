package com.example.labo04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labo04.View.TaskScreen
import com.example.labo04.ViewModel.GeneralViewModel
import com.example.labo04.ui.theme.Labo04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo04Theme {
                val navController = rememberNavController()
                val viewModel: GeneralViewModel = viewModel()

                NavHost(navController = navController, startDestination = "task_screen") {
                    composable("task_screen") {
                        TaskScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
