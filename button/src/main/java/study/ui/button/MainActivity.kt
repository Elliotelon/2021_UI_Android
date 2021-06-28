package study.ui.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import study.ui.button.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null

    private val binding get() = mBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //버튼에 리스너를 설정한다.
        binding?.button1?.setOnClickListener(listener1)

        binding?.imageButton1?.setOnClickListener(listener2)

        binding?.button2?.setOnClickListener(listener3)
        binding?.button3?.setOnClickListener(listener3)

        binding?.button4?.setOnClickListener {
            binding?.text1?.text = "다섯 번째 버튼을 눌렀습니다."
        }


    }

    // 버튼을 클릭하면 동작하는 리스너 객체

    val listener1 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding?.text1?.text = " 첫 번째 버튼을 눌렀습니다."
        }

    }

    val listener2 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding?.text1?.text = " 두 번째 버튼을 눌렀습니다."
        }

    }

    val listener3 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.button2 -> {
                    binding?.text1?.text = "세 번째 버튼을 눌렀습니다."
                }
                R.id.button3 -> {
                    binding?.text1?.text = "네 번째 버튼을 눌렀습니다."
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}