package com.dsm.desafio_01_dsm

import java.util.ArrayList

class Employee {
    var name: String
    var baseSalary: Double
    var isssDeduction: Double
    var afpDeduction: Double
    var rentDeduction: Double
    var totalDeductions: Double
    var netSalary: Double

    constructor(){
        this.name = ""
        this.baseSalary = 0.0
        this.isssDeduction = 0.0
        this.afpDeduction = 0.0
        this.rentDeduction = 0.0
        this.totalDeductions = 0.0
        this.netSalary = 0.0
    }
    fun setValues(name: String, baseSalary: String): StatusResult{
        val employee_name = name
        val salary = baseSalary.toDoubleOrNull()
        val errors = ArrayList<String>()

        if (employee_name == null || employee_name == ""){
            errors.add("El nombre del empleado es requerido.\n")
        }
        if (salary == null || salary < 0){
            errors.add("Debe ingresar un salario base válido (número mayor o igual a 0).\n")
        }

        if(errors.isNotEmpty()){
            return StatusResult(false, errors)
        }
        this.baseSalary = salary!!
        this.isssDeduction = this.baseSalary * (0.03)
        this.afpDeduction = this.baseSalary * (0.04)
        this.rentDeduction = this.baseSalary * (0.05)
        this.totalDeductions = this.isssDeduction + this.afpDeduction + this.rentDeduction
        this.netSalary = this.baseSalary - this.totalDeductions
        return StatusResult(true)
    }
}






