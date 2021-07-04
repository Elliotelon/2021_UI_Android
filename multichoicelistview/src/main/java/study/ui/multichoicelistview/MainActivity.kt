package study.ui.multichoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val list1 by lazy {findViewById<ListView>(R.id.list1)}

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data1)

        list1.adapter = adapter1
        list1.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        list1.setItemChecked(0, true)
        list1.setItemChecked(2, true)
        list1.setItemChecked(4, true)

        button.setOnClickListener {
            textView.text = ""

            //현재 체크 상태에 관련된 객체를 가져온다.
            val boolArray = list1.checkedItemPositions

            //textView.text = "개수 : ${boolArray.size()}"

            for (idx in 0 until boolArray.size()){
                //textView.append("${boolArray.keyAt(idx)} ")

                //항목의 인덱스 번호
                val key = boolArray.keyAt(idx)

                if(boolArray[key] == true){
                    textView.append("${data1[key]}, ")
                }
            }
        }

    }
}