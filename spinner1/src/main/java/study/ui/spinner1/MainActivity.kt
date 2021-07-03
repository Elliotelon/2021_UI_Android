package study.ui.spinner1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val spinner by lazy {findViewById<Spinner>(R.id.spinner)}
    private val button by lazy {findViewById<Button>(R.id.button)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //어댑터를 생성한다. 접혔을 때 모습을 구성할 layout을 설정한다.
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)

        //펼쳐졌을 때의 모습을 구성하기 위한 layout을 지정한다.
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1

        button.setOnClickListener {
            textView.text = "선택한 항목 ${data1[spinner.selectedItemPosition]}"
        }

        spinner.onItemSelectedListener = listener1
    }

    val listener1 = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.spinner -> {
                    textView.text = "${data1[position]} 번째 항목이 선택 되었습니다."
                }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }
}