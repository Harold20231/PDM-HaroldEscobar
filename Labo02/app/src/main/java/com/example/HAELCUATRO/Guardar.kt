package com.example.HAELCUATRO

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
public fun FormularioNombres() {

    var nombre by remember { mutableStateOf("") }
    var listaNombres by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = nombre,
            onValueChange = { nuevoNombre ->
                nombre = nuevoNombre
            },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF5369A1),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF5369A1)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                listaNombres + nombre
                println("Guardando nombre: $nombre")

            },
            modifier = Modifier.widthIn(min = 150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5369A1)
            )
        ) {
            Text("Guardar")
        }
    }


}