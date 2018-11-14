package com.example.motion

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.motion.sample.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItem(AutoAnimateLayoutActivity::class.java)
        addItem(ViewAnimationActivity::class.java)
        addItem(PropertyAnimatorActivity::class.java)
        addItem(AnimateBetweenActivity::class.java)
        addItem(LayoutTransitionActivity::class.java)
        addItem(CollapsingToolbarActivity::class.java)

        addItem(MotionLayoutActivity::class.java)
        addItem(MotionLayoutEasyActivity::class.java)
        addItem(MotionLayoutCustomViewActivity::class.java)
        addItem(MotionLayoutPathActivity::class.java)
        addItem(CoordinatorWithPropertyActivity::class.java)
    }

    fun addItem(param: Class<*>, name: String = param.simpleName) {
        findViewById<LinearLayout>(R.id.content)!!.let {
            val view = LayoutInflater.from(applicationContext).inflate(android.R.layout.simple_list_item_1, null)
            view.findViewById<TextView>(android.R.id.text1).setText(param.simpleName)
            view!!.setOnClickListener {
                startActivity(Intent(this, param))
            }

            it.addView(view)
        }
    }
}
