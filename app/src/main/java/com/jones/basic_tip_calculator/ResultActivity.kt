package com.jones.basic_tip_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tipAmount = intent.getDoubleExtra("tipAmount", 0.0)
        val totalBill = intent.getDoubleExtra("totalBill", 0.0)

        val tipAmountTextView = findViewById<TextView>(R.id.textViewTipAmount)
        val totalBillTextView = findViewById<TextView>(R.id.textViewTotalBill)

        tipAmountTextView.text = "Tip Amount: $${String.format("%.2f", tipAmount)}"
        totalBillTextView.text = "Total Bill (including tip): $${String.format("%.2f", totalBill)}"

        val returnButton = findViewById<Button>(R.id.buttonReturn)

        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}