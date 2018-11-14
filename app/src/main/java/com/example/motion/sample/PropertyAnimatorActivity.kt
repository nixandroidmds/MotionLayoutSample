package com.example.motion.sample

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motion.R
import kotlinx.android.synthetic.main.activity_button.*

class PropertyAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        button.setOnClickListener {
            ValueAnimator.ofFloat(button.x, button.x + 255).apply {
                addUpdateListener {
                    button.x = it.animatedValue as Float
                    button.setText("${it.animatedValue}")
                }
                setDuration(600)
                start()
            }
        }
    }
}
