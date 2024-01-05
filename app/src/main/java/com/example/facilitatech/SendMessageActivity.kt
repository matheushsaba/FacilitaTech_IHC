package com.example.facilitatech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class SendMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        val sendMessageEditText = findViewById<EditText>(R.id.sendMessageEditText)
        val sendMessageButton = findViewById<Button>(R.id.sendMessageButton)

        sendMessageButton.setOnClickListener {
            val message = sendMessageEditText.text.toString()
            val intent = Intent(this, ShowReceivedMessageActivity::class.java).apply {
                putExtra("EXTRA_MESSAGE", message)
            }
            startActivity(intent)
        }
    }
}