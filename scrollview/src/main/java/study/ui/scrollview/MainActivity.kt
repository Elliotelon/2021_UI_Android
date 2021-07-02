package study.ui.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    private val scroll1 by lazy {findViewById<ScrollView>(R.id.scroll1)}
    private val scroll2 by lazy {findViewById<HorizontalScrollView>(R.id.scroll2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Y : ${scroll1.scrollY}"
            textView2.text = "X : ${scroll2.scrollX}"
        }

        button2.setOnClickListener {
            //지정된 위치로 애니메이션 없이 이동
            //scroll1.scrollTo(0, 500)
            //scroll2.scrollTo(500, 0)

            //지정된 위치로 애니메이션과 함께 이동
            //scroll1.smoothScrollTo(0, 500)
            //scroll2.smoothScrollTo(500, 0)

            //현재 위치에서 지정된 만큼 애니메이션과 함께 이동
            scroll1.smoothScrollBy(0, 500)
            scroll2.smoothScrollBy(500, 0)
        }

        scroll1.setOnScrollChangeListener(listener1)
        scroll2.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            textView2.text = "X : ${oldScrollX} -> ${scrollX}"
        }
    }

    val listener1 = object : View.OnScrollChangeListener {
        override fun onScrollChange(
            v: View?,
            scrollX: Int,
            scrollY: Int,
            oldScrollX: Int,
            oldScrollY: Int
        ) {
            when(v?.id){
                R.id.scroll1 -> {
                    textView.text = "Y : ${oldScrollY} -> ${scrollY}"
                }
            }
        }

    }
}