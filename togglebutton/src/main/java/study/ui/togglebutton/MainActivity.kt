package study.ui.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    private val button by lazy { findViewById<Button>(R.id.button)}
    private val button2 by lazy { findViewById<Button>(R.id.button2)}
    private val button3 by lazy { findViewById<Button>(R.id.button3)}
    private val button4 by lazy { findViewById<Button>(R.id.button4)}
    private val toggleButton by lazy { findViewById<ToggleButton>(R.id.toggleButton)}
    private val toggleButton2 by lazy { findViewById<ToggleButton>(R.id.toggleButton2)}
    private val textView by lazy { findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy { findViewById<TextView>(R.id.textView2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(toggleButton.isChecked == true) {
                textView.text = "ON 상태 입니다."
            } else {
                textView.text = "OFF 상태 입니다."
            }
        }

        button2.setOnClickListener {
            toggleButton.isChecked = true
        }

        button3.setOnClickListener {
            toggleButton.isChecked = false
        }

        button4.setOnClickListener {
            toggleButton.toggle()
        }

        toggleButton.setOnClickListener(listener)

        toggleButton2.setOnClickListener {
            if(toggleButton2.isChecked == true) {
                textView2.text = "ON 상태로 설정 되었습니다."
            } else {
                textView2.text = "OFF 상태로 설정 되었습니다."
            }
        }
    }

    val listener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            if(toggleButton.isChecked == true) {
                textView.text = "ON 상태로 설정 되었습니다."
            } else {
                textView.text = "OFF 상태로 설정 되었습니다."
            }
        }

    }
}