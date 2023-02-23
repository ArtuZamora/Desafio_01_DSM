package com.dsm.desafio_01_dsm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EmployeeSalaryActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_salary)

        val name = findViewById<EditText>(R.id.employee_ipt)
        val salary = findViewById<EditText>(R.id.baseSalary_ipt)
        val processBtn = findViewById<Button>(R.id.calc_btn2)
        val result = findViewById<TextView>(R.id.result_lbl2)

        processBtn.setOnClickListener {
            val name = name.text.toString()
            val salary = salary.text.toString().toDoubleOrNull()
            val errors = ArrayList<String>()
            if (name == null || name == ""){
                errors.add("El nombre del empleado es requerido.\n")
            }
            if (salary == null || salary < 0){
                errors.add("Debe ingresar un salario base válido.\n")
            }
            if(errors.isNotEmpty()){
                result.setText(errors.joinToString("\n"))
                return@setOnClickListener
            }
            val isssDeduction = salary!! * (0.03)
            val afpDeduction = salary!! * (0.04)
            val rentDeduction = salary!! * (0.05)
            val totalDeductions = isssDeduction + afpDeduction + rentDeduction
            val netSalary = salary!! - totalDeductions
            val message = StringBuilder()
            message.append("Nombre del empleado: ${name}\n")
            message.append("Salario base: \$${salary}\n")
            message.append("ISSS (-3%): \$${isssDeduction}\n")
            message.append("AFP (-4%): \$${afpDeduction}\n")
            message.append("Renta (-5%): \$${rentDeduction}\n")
            message.append("Total de deducciones: \$${totalDeductions}\n")
            message.append("Salario neto: \$${netSalary}\n")
            result.setText(message.toString())
        }
    }

    /** Menu creation and actions */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_1){
            Toast.makeText(this, "Menú principal", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.option_1) {
            Toast.makeText(this, "Cálculo de promedio de un estudiante", Toast.LENGTH_LONG).show()
            val intent = Intent(this, StudentGradesActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.option_2) {
            Toast.makeText(this, "Salario neto de un empleado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, EmployeeSalaryActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.option_3) {
            Toast.makeText(this, "Calculadora básica", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}









