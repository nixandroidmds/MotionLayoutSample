package com.example.motion.sample

import android.os.Bundle
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.motion.R
import kotlinx.android.synthetic.main.activity_button.*

class ViewAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        button.setOnClickListener {

            val animation = TranslateAnimation(0f, 255f, 0f, 0f).apply {
                duration = 600
                fillAfter = true
            }
            button.startAnimation(animation)


        }
    }
}
