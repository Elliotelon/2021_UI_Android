package study.ui.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val autoCompleteTextView by lazy {findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)}

    private val button by lazy {findViewById<Button>(R.id.button)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    val data1 = arrayOf(
        "abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

        autoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            textView.text = autoCompleteTextView.text
        }

        autoCompleteTextView.setOnItemClickListener(listener1)
    }

    val listener1 = object : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView2.text = "${data1[position]} 항목을 클릭했습니다."
        }
    }
}