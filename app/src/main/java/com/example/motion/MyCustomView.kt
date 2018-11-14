@file:Suppress("unused", "SetTextI18n")

package com.example.motion

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MyCustomView(context: Context?, attrs: AttributeSet?)
    : TextView(context, attrs) {

    fun setPosition(int: Int) {
        text = "position = $int"
    }
}



