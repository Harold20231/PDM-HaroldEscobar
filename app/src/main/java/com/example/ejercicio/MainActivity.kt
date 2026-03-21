package com.example.ejercicio

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ejercicio.ui.theme.EjercicioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val misProgramas = listOf("Notion 2026", "Facebook 2024", "Android Studio 2026", "Spotify 2022")
        val miPC = Computadora(16, 512, "Windows 11 Pro", misProgramas)
        miPC.encenderComputadora()
        Log.d("PRUEBA", "Programas 2026: ${miPC.obtenerProgramas()}")
        miPC.actualizar(32, 1024, "Linux Ubuntu")
        miPC.apagarComputadora()

        val miCalc = Calculadora("Casio", 5, 20.0)
        Log.d("PRUEBA", "Suma: ${miCalc.sumar(5.0, 10.0)}")
        Log.d("PRUEBA", "División por cero: ${miCalc.dividir(10.0, 0.0)}")

        val ciclo01 = listOf(
            Estudiante("Juan", "001", "Programación de Dispositivos Móviles"),
            Estudiante("Maria", "002", "Análisis numérico"),
            Estudiante("Pedro", "003", "Programación de Dispositivos Móviles"),
            Estudiante("Ana", "004", "Análisis numérico"),
            Estudiante("Luis", "005", "Programación de Dispositivos Móviles")
        )

        val soloMoviles = ciclo01.filter { it.asignatura == "Programación de Dispositivos Móviles" }
        Log.d("PRUEBA", "Estudiantes en Móviles: ${soloMoviles.map { it.nombre }}")

        setContent {
            EjercicioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}