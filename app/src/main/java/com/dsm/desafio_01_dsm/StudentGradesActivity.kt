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
        setTitle("Calculo de promedio")

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
            val grade1 = grade_1.text.toString()
            val grade2 = grade_2.text.toString()
            val grade3 = grade_3.text.toString()
            val grade4 = grade_4.text.toString()
            val grade5 = grade_5.text.toString()

            val student = Student()
            val setResultStatus =
                student.setValues(
                    student_name,
                    arrayListOf<String>(grade1, grade2, grade3, grade4, grade5))

            if(!setResultStatus.success){
                result.setText(setResultStatus.errors.joinToString("\n"))
                return@setOnClickListener
            }
            result.setText("Nombre del estudiante: ${student.name}\n Promedio: ${student.prom}\n El estudiante está: ${student.status}")
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
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        if (id == R.id.option_1) {
            Toast.makeText(this, "Cálculo de promedio de un estudiante", Toast.LENGTH_LONG).show()
            val intent = Intent(this, StudentGradesActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        if (id == R.id.option_2) {
            Toast.makeText(this, "Salario neto de un empleado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, EmployeeSalaryActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        if (id == R.id.option_3) {
            Toast.makeText(this, "Calculadora básica", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CalculatorActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}








