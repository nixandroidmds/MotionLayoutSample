package com.example.motion.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_transition_1.*
import android.app.ActivityOptions
import android.util.Pair
import com.example.motion.R


class AnimateBetweenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_1)

        container.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                    Pair(imageView, "image"),
                    Pair(textView, "text"),
                    Pair(container, "container")
            )

            startActivity(Intent(this, AnimateBetweenActivity2::class.java), options.toBundle())
        }
    }
}
