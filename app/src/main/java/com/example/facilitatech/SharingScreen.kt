package com.example.facilitatech

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.DialogFragment
import com.example.facilitatech.components.RecordingButton
import com.example.facilitatech.components.RecordingInfo
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

// custom dialog personalizado
class DialogExitScreen (
    val positiveAction: () -> Unit,
    val negativeAction: () -> Unit
): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Você tem certeza que deseja sair da chamada?")
                .setPositiveButton("Sim") { dialog, id ->
                    positiveAction()
                }
                .setNegativeButton("Não") { dialog, id ->
                    negativeAction()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

class SharingScreen : AppCompatActivity() {
    private lateinit var textViewTouchX: TextView
    private lateinit var textViewTouchY: TextView
    private var drawingOnScreen: Boolean = false
    private fun setupTouchVariables() {
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

                if (drawingOnScreen) {
                    drawnOnScreen()
                }
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    fun positiveDialogExitAction() {
        Log.d("DialogCall", "Sim, exit call")

        finish()
    }

    fun negativeDialogExitAction() {
        Log.d("DialogCall", "Não, continue na call")
    }

    fun selectDrawPencil(view: View) {
        Log.d("tools", "selectDrawPencil")
        drawingOnScreen = !drawingOnScreen
    }
    fun drawnOnScreen() {
        Log.d("tools", "drawnOnScreen")
    }

    fun cleanScreen(view: View) {
        Log.d("tools", "clean screen")
    }

    fun selectPencilColor(view: View) {
        Log.d("tools", "select pencil color")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharing_screen)

        setupTouchVariables()
        // not work
//        findViewById<Button>(R.id.buttonDrawOnCall)
//            .setOnClickListener {
//                 // Log.d("buttons", "User want to exit the call")
//                 // Logger.getLogger(Test::class.java.name).warning("Hello..")
//            }
        findViewById<ImageButton>(R.id.buttonExitCall)
            .setOnClickListener(View.OnClickListener { view ->
                DialogExitScreen(
                    { positiveDialogExitAction() },
                    { negativeDialogExitAction() }
                ).show(supportFragmentManager, "GAME_DIALOG")
            })

        findViewById<ImageButton>(R.id.buttonDrawOnCall)
            .setOnClickListener(View.OnClickListener { view ->
                selectDrawPencil(view)
        })

        findViewById<ImageButton>(R.id.buttonCleanScreenCall)
            .setOnClickListener(View.OnClickListener { view ->
                cleanScreen(view)
            })

        findViewById<ImageButton>(R.id.buttonChooseColorCall)
            .setOnClickListener(View.OnClickListener { view ->
                selectPencilColor(view)
            })
    }
}
