package com.dsm.desafio_01_dsm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        val num1Ipt = findViewById<EditText>(R.id.firstNumber_ipt)
        val num2Ipt = findViewById<EditText>(R.id.secondNumber_ipt)
        val processBtn = findViewById<Button>(R.id.calc_btn3)
        val resultLbl = findViewById<TextView>(R.id.result_lbl3)

        /** Spinner fill with data */
        val spinner = findViewById<Spinner>(R.id.operation_spinner)
        val operations = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val spinnerAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operations)
        spinner.adapter = spinnerAdapter

        /** OnClick process operations */
        processBtn.setOnClickListener{
            val operation = spinner.getSelectedItem().toString()
            Log.i("OPERATION",operation)
            val n1 = num1Ipt.text.toString().toDoubleOrNull()
            val n2 = num2Ipt.text.toString().toDoubleOrNull()
            if(n1 != null && n2 != null){
                var res: Double = 0.toDouble()
                when(operation){
                    "Sumar" -> {res = n1 + n2}
                    "Restar" -> {res = n1 - n2}
                    "Multiplicar" -> {res = n1 * n2}
                    "Dividir" -> {
                        if(n2 == 0.toDouble()){
                            Toast.makeText(applicationContext, "No se puede dividir entre 0",
                                Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }
                        res = n1 / n2
                    }
                }
                resultLbl.setText(res.toString())
            }
            else
                Toast.makeText(applicationContext, "Debe ingresar número válidos",
                    Toast.LENGTH_LONG).show()
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