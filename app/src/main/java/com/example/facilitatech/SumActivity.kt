package com.example.facilitatech
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class SumActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)

        val firstNumberEditText = findViewById<EditText>(R.id.firstNumberEditText)
        val secondNumberEditText = findViewById<EditText>(R.id.secondNumberEditText)
        val sumButton = findViewById<Button>(R.id.sumButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        sumButton.setOnClickListener {
            val firstNumber = firstNumberEditText.text.toString().toDoubleOrNull() ?: 0.0
            val secondNumber = secondNumberEditText.text.toString().toDoubleOrNull() ?: 0.0
            val sum = firstNumber + secondNumber
            resultTextView.text = "Result: $sum"
        }
    }
}