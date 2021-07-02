package study.ui.customlistview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val rowTextView by lazy {findViewById<TextView>(R.id.rowTextView)}
    private val list1 by lazy {findViewById<ListView>(R.id.list1)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    val data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
        list1.adapter = adapter1

        list1.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${data1[position]} 을(를) 터치하였습니다."
        }
    }
}