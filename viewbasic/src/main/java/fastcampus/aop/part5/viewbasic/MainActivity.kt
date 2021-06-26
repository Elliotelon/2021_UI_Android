package fastcampus.aop.part5.viewbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fastcampus.aop.part5.viewbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null

    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}