package com.dsm.desafio_01_dsm

import android.widget.Toast
import java.util.ArrayList

class Calculation {
    var number1: Double
    var number2: Double
    var operation: String
    var result: Double

    constructor(){
        this.number1 = 0.0
        this.number2 = 0.0
        this.operation = ""
        this.result = 0.0
    }

    fun operate(number1: String, number2: String, operation: String): StatusResult{
        val n1 = number1.toDoubleOrNull()
        val n2 = number2.toDoubleOrNull()
        val errors = ArrayList<String>()

        if (operation == null || operation == ""){
            errors.add("Debe seleccionar una operación.\n")
        }
        if(n1 == null){
            errors.add("El primer número debe ser un valor numérico válido.\n")
        }
        if(n2 == null){
            errors.add("El segundo número debe ser un valor numérico válido.\n")
        }
        if(errors.isNotEmpty()){
            return StatusResult(false, errors)
        }
        this.number1 = n1!!
        this.number2 = n2!!
        when(operation){
            "Sumar" -> {this.result = n1 + n2}
            "Restar" -> {this.result = n1 - n2}
            "Multiplicar" -> {this.result = n1 * n2}
            "Dividir" -> {
                if(n2 == 0.toDouble()){
                    errors.add("Para una división el segundo número debe ser distinto de 0.\n")
                    return StatusResult(false, errors)
                }
                this.result = n1 / n2
            }
        }
        return StatusResult(true)
    }
}






