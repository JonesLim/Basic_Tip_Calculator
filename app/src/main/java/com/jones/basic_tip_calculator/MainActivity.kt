package com.jones.basic_tip_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.buttonCalculate)

        btnCalculate.setOnClickListener {
            val billAmount = findViewById<EditText>(R.id.editTextBillAmount).text.toString().toDoubleOrNull()
            val tipPercentage = findViewById<EditText>(R.id.editTextTipPercentage).text.toString().toDoubleOrNull()

            if (billAmount != null && tipPercentage != null) {
                val tipAmount = (billAmount * (tipPercentage / 100))
                val totalBill = billAmount + tipAmount

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("tipAmount", tipAmount)
                intent.putExtra("totalBill", totalBill)
                startActivity(intent)
            }
        }
    }
}