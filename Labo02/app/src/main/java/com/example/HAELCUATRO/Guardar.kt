package com.example.HAELCUATRO

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FormularioNombres() {
    // Definimos el estado de la aplicación
    var nombre by remember { mutableStateOf("") }
    var listaNombres by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nuevoNombre -> nombre = nuevoNombre },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
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
                if (nombre.isNotBlank()) {
                    listaNombres = listaNombres + nombre
                    nombre = ""
                    println("Guardando nombre: $nombre. Lista actual: $listaNombres")
                }
            },
            modifier = Modifier.widthIn(min = 120.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5369A1)
            )
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(24.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y\nposición en la lista",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            // Botón "Limpiar"
            Button(
                onClick = {
                    listaNombres = emptyList()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5369A1)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(listaNombres) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item) // Nombre
                        Text(text = "${index + 1}")
                    }
                }
            }
        }
    }
}