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
import com.dsm.desafio_01_dsm.R

class StudentGradesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_grades)

        val name = findViewById<EditText>(R.id.student_ipt)
        val grade_1 = findViewById<EditText>(R.id.grade1_ipt)
        val grade_2 = findViewById<EditText>(R.id.grade2_ipt)
        val grade_3 = findViewById<EditText>(R.id.grade3_ipt)
        val grade_4 = findViewById<EditText>(R.id.grade4_ipt)
        val grade_5 = findViewById<EditText>(R.id.grade5_ipt)
        val processBtn = findViewById<Button>(R.id.calc_btn)
        val result = findViewById<TextView>(R.id.result_lbl)

        processBtn.setOnClickListener{
            val student_name = name.text.toString()
            val grade1 = grade_1.text.toString().toDoubleOrNull()
            val grade2 = grade_2.text.toString().toDoubleOrNull()
            val grade3 = grade_3.text.toString().toDoubleOrNull()
            val grade4 = grade_4.text.toString().toDoubleOrNull()
            val grade5 = grade_5.text.toString().toDoubleOrNull()

            val errors = ArrayList<String>()
            if (student_name == null || student_name == ""){
                errors.add("El nombre del estudiante es requerido.\n")
            }
            if (grade1 == null || grade1 < 0 || grade1 > 10){
                errors.add("La nota 1 debe ser válida (número entre 0 y 10).\n")
            }
            if (grade2 == null || grade2 < 0 || grade2 > 10){
                errors.add("La nota 2 debe ser válida (número entre 0 y 10).\n")
            }
            if (grade3 == null || grade3 < 0 || grade3 > 10){
                errors.add("La nota 3 debe ser válida (número entre 0 y 10).\n")
            }
            if (grade4 == null || grade4 < 0 || grade4 > 10){
                errors.add("La nota 4 debe ser válida (número entre 0 y 10).\n")
            }
            if (grade5 == null || grade5 < 0 || grade5 > 10){
                errors.add("La nota 5 debe ser válida (número entre 0 y 10).\n")
            }

            if(errors.isNotEmpty()){
                result.setText(errors.joinToString("\n"))
                return@setOnClickListener
            }
            val prom = (grade1!! + grade2!! + grade3!! + grade4!! + grade5!!) / 5
            val status = if(prom < 6) "Reprobado" else "Aprobado"
            result.setText("Nombre del estudiante: ${student_name}\n Promedio: ${prom}\n El estudiante está: ${status}")
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








