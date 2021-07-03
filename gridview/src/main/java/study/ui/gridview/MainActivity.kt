package study.ui.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val grid1 by lazy {findViewById<GridView>(R.id.grid1)}

    val data1 = arrayOf(
        "그리드1", "그리드2", "그리드3", "그리드4", "그리드5",
        "그리드6", "그리드7", "그리드8", "그리드9", "그리드10",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)

        grid1.adapter = adapter1

        grid1.setOnItemClickListener(listener1)

    }

    val listener1 = object : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.grid1 -> {
                    textView.text = "${data1[position]} 번째 항목을 클릭 하였습니다."
                }
            }
        }

    }
}