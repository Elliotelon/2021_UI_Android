package study.ui.checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val checkedTextView by lazy {findViewById<CheckedTextView>(R.id.checkedTextView)}
    private val checkedTextView2 by lazy {findViewById<CheckedTextView>(R.id.checkedTextView2)}
    private val checkedTextView3 by lazy {findViewById<CheckedTextView>(R.id.checkedTextView3)}
    private val checkedTextView4 by lazy {findViewById<CheckedTextView>(R.id.checkedTextView4)}
    private val checkedTextView5 by lazy {findViewById<CheckedTextView>(R.id.checkedTextView5)}
    private val checkedTextView6 by lazy {findViewById<CheckedTextView>(R.id.checkedTextView6)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            textView.text = ""

            //체크박스
            if(checkedTextView.isChecked == true){
                textView.append("첫 번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView.append("첫 번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if(checkedTextView2.isChecked == true){
                textView.append("두 번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView.append("두 번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if(checkedTextView3.isChecked == true){
                textView.append("세 번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView.append("세 번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if(checkedTextView4.isChecked == true){
                textView.append("첫 번째 라디오 버튼이 선택되어 있습니다.\n")
            } else if(checkedTextView5.isChecked == true){
                textView.append("두 번째 라디오 버튼이 선택되어 있습니다.\n")

            } else if(checkedTextView6.isChecked == true){
                textView.append("세 번째 라디오 버튼이 선택되어 있습니다.\n")

            }
        }

        button2.setOnClickListener {
            checkedTextView.isChecked = false
            checkedTextView2.isChecked = true
            checkedTextView3.isChecked = false
            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = true
        }

        checkedTextView.setOnClickListener(listener1)
        checkedTextView2.setOnClickListener(listener1)
        checkedTextView3.setOnClickListener(listener1)

        checkedTextView4.setOnClickListener(listener2)
        checkedTextView5.setOnClickListener(listener2)
        checkedTextView6.setOnClickListener(listener2)
    }

    val listener1 = object :View.OnClickListener {
        override fun onClick(v: View?) {

            //형 변환
            val obj = v as CheckedTextView

            if(obj.isChecked == true){
                obj.isChecked = false
            } else {
                obj.isChecked = true
            }
        }
    }

    val listener2 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = false

            val obj = v as CheckedTextView
            obj.isChecked = true
        }

    }
}