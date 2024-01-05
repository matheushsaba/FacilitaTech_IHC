package com.example.facilitatech

import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.activity.ComponentActivity

class TouchValueActivity : ComponentActivity() {

    private lateinit var textViewTouchX: TextView
    private lateinit var textViewTouchY: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_value)

        textViewTouchX = findViewById(R.id.tv_touch_x)
        textViewTouchY = findViewById(R.id.tv_touch_y)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val touchX = event.x
                val touchY = event.y
                textViewTouchX.text = String.format("%.0f", touchX)
                textViewTouchY.text = String.format("%.0f", touchY)
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}