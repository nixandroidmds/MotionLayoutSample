package com.example.motion.sample

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import com.example.motion.R
import kotlinx.android.synthetic.main.activity_layout_transition.*

class LayoutTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_transition)

        var currentScene: Scene? = null

        container.setOnClickListener {
            val firstScene: Scene
            val secondScene: Scene

            firstScene = Scene.getSceneForLayout(container, R.layout.activity_transition_1, this)

            secondScene = Scene.getSceneForLayout(container,
                    R.layout.activity_transition_2,
                    this)
            currentScene = if (currentScene == secondScene) firstScene else secondScene


            TransitionManager.go(currentScene, ChangeBounds())
        }
    }
}
