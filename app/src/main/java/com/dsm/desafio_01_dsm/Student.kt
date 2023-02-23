package com.dsm.desafio_01_dsm

import java.util.ArrayList

class Student {
    var name: String
    var grades: ArrayList<Double>
    var prom: Double
    var status: String

    constructor(){
        this.name = ""
        this.grades = ArrayList<Double>()
        this.prom = 0.0
        this.status = ""
    }

    fun setValues(name: String, grades: ArrayList<String>): StatusResult{
        val student_name = name
        val correctGrades = ArrayList<Double>()
        val errors = ArrayList<String>()

        if (student_name == null || student_name == ""){
            errors.add("El nombre del estudiante es requerido.\n")
        }
        grades.forEachIndexed { index, element ->
            val grade = element.toDoubleOrNull()
            if(grade == null || grade < 0 || grade > 10){
                errors.add("La nota ${index + 1} debe ser válida (número entre 0 y 10).\n")
            }else{
                correctGrades.add(grade!!)
            }
        }
        if(errors.isNotEmpty()){
            return StatusResult(false, errors)
        }
        this.name = student_name
        this.grades = correctGrades
        this.prom = if(correctGrades.isNotEmpty()) correctGrades.sum() / correctGrades.count() else 0.0
        this.status = if(prom < 6) "Reprobado" else "Aprobado"
        return StatusResult(true)
    }
}












