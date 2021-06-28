package study.ui.textinputlayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val button1 by lazy { findViewById<Button>(R.id.button1) }
    private val textView1 by lazy { findViewById<TextView>(R.id.textView1) }
    private val textInputLayout1 by lazy { findViewById<TextInputLayout>(R.id.textInputLayout1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text = textInputLayout1.editText?.text

            textInputLayout1.editText?.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textInputLayout1.editText?.windowToken, 0)
        }

        textInputLayout1.editText?.addTextChangedListener(listener1)

    }

    val listener1 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(s != null) {
                if(s.length > 10) {
                    textInputLayout1.error = "10글자 이하로 입력해주세요."
                } else {
                    textInputLayout1.error = null
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }
}