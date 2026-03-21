package com.example.ejercicio

import android.util.Log

class Calculadora(
    val marca: String,
    val aniosVida: Int,
    var precio: Double
) {

    fun sumar(a: Double, b: Double): Double = a + b

    fun restar(a: Double, b: Double): Double = a - b

    fun multiplicar(a: Double, b: Double): Double = a * b

    fun dividir(a: Double, b: Double): Any {
        return if (b != 0.0) {
            a / b
        } else {
            "No se puede dividir entre cero"
        }
    }
}