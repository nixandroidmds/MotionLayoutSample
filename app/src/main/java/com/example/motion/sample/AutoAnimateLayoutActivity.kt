package com.example.motion.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motion.R
import kotlinx.android.synthetic.main.activity_auto_animate.*

@SuppressLint("SetTextI18n")
class AutoAnimateLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_animate)

        addButton.setOnClickListener {

            val textView = TextView(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)

                setBackgroundColor(ContextCompat.getColor(context,
                        android.R.color.holo_red_dark))
                text = "New view"

                setOnClickListener {
                    container.removeView(it)
                }
            }

            container.addView(textView)
        }
    }
}






