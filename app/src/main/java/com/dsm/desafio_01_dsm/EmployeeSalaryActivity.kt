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

        setTitle("Cálculo de salario neto")

        val name = findViewById<EditText>(R.id.employee_ipt)
        val salary = findViewById<EditText>(R.id.baseSalary_ipt)
        val processBtn = findViewById<Button>(R.id.calc_btn2)
        val result = findViewById<TextView>(R.id.result_lbl2)

        processBtn.setOnClickListener {
            val name = name.text.toString()
            val salary = salary.text.toString()
            val employee = Employee()
            val setResultStatus = employee.setValues(name, salary)
            if(!setResultStatus.success){
                result.setText(setResultStatus.errors.joinToString("\n"))
                return@setOnClickListener
            }
            val message = StringBuilder()
            message.append("Nombre del empleado: ${employee.name}\n")
            message.append("Salario base: \$${employee.baseSalary}\n")
            message.append("ISSS (-3%): \$${employee.isssDeduction}\n")
            message.append("AFP (-4%): \$${employee.afpDeduction}\n")
            message.append("Renta (-5%): \$${employee.rentDeduction}\n")
            message.append("Total de deducciones: \$${employee.totalDeductions}\n")
            message.append("Salario neto: \$${employee.netSalary}\n")
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









