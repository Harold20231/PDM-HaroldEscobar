package com.example.ejercicio

import android.util.Log

class Computadora(

    var ram: Int,

    var almacenamiento: Int,

    var sistemasOperativo: String,

    var programasInstalados: List<String>

){


    fun encenderComputadora(){

        Log.d("PRUEBA" , "Computadora encendida")

    }


    fun apagarComputadora(){

        Log.d("PRUEBA","computadora apagada")

    }


    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSO: String){

        ram = nuevaRam

        almacenamiento = nuevoAlma

        sistemasOperativo = nuevoSO

        Log.d("PRUEBA", "computadora actualizada")

    }


    fun obtenerProgramas(): List<String>{

        return programasInstalados.filter { it.contains("2026")}

    }

}