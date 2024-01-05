package com.example.facilitatech

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.math.abs

class AccelerometerValuesActivity : ComponentActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private lateinit var textViewX: TextView
    private lateinit var textViewY: TextView
    private lateinit var textViewZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer_values)

        textViewX = findViewById(R.id.tv_accelerometer_x)
        textViewY = findViewById(R.id.tv_accelerometer_y)
        textViewZ = findViewById(R.id.tv_accelerometer_z)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val values = event.values
            val xValue = values[0]
            val yValue = values[1]
            val zValue = values[2]

            textViewX.text = String.format("%.2f", xValue)
            textViewY.text = String.format("%.2f", yValue)
            textViewZ.text = String.format("%.2f", zValue)

            if (abs(xValue) > 25){
                val message = "Slow down!\nYou got $xValue on X axis"
                val intent = Intent(this, ShowReceivedMessageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", message)
                }
                sensorManager.unregisterListener(this)
                startActivity(intent)
            }
            else if (abs(yValue) > 25){
                val message = "Slow down!\nYou got $yValue on Y axis"
                val intent = Intent(this, ShowReceivedMessageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", message)
                }
                sensorManager.unregisterListener(this)
                startActivity(intent)
            }
            else if (abs(zValue) > 25){
                val message = "Slow down!\nYou got $zValue on Z axis"
                val intent = Intent(this, ShowReceivedMessageActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", message)
                }
                sensorManager.unregisterListener(this)
                startActivity(intent)
            }

        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}