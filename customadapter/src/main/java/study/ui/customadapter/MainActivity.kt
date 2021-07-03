package study.ui.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val list1 by lazy {findViewById<ListView>(R.id.list1)}

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1.adapter = adapter1
    }

    val adapter1 = object : BaseAdapter() {

        //항목 하나를 구성하기 위해 호출되는 메소드
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //재사용 가능한 View를 변수에 담는다.
            var rowView = convertView

            if(rowView == null){
                rowView = layoutInflater.inflate(R.layout.row, null)

            }

            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)

            text1?.text = data1[position]

            btn1?.tag = position
            btn2?.tag = position

            btn1?.setOnClickListener {
                textView.text = "첫 번째 버튼을 눌렀습니다.  : ${it.tag}"
            }

            btn2?.setOnClickListener {
                textView.text = "두 번째 버튼을 눌렀습니다. : ${it.tag}"
            }

            return rowView!!
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        //항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }

    }
}