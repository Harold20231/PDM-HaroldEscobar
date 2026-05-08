package com.pdm0126.labo03

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight


@Composable
fun HomeScreen(onNavigateToNames: () -> Unit, onNavigateToSensors: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Laboratorio", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onNavigateToNames) {
            Text("Lista de nombres")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToSensors) {
            Text("Información de sensores")
        }
    }
}

