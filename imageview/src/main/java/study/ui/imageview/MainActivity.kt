package study.ui.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val imageView3 by lazy { findViewById<ImageView>(R.id.imageView3)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView3.setImageResource(R.drawable.ic_launcher_background)
    }
}