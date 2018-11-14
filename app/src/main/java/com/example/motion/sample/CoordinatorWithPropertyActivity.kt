package com.example.motion.sample

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.motion.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_coordinator_layout.*

class CoordinatorWithPropertyActivity : AppCompatActivity() {

    companion object {
        const val SMALL_PHOTO_ANIMATION_START = 94
        const val PHOTO_ANIMATION_START = 70
    }

    private val dimen50 by lazy { resources.getDimensionPixelSize(R.dimen.dimen50) }
    private val dimen30 by lazy { resources.getDimensionPixelSize(R.dimen.dimen30) }
    private val dimen100 by lazy { resources.getDimensionPixelSize(R.dimen.dimen100) }
    private val dimen130 by lazy { resources.getDimensionPixelSize(R.dimen.dimen130) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, p1: Int) {
                notifyProgress(Math.abs(p1).toFloat() / appBarLayout!!.height * 100, p1)
            }
        })
    }

    private fun notifyProgress(progress: Float, position: Int) {
        updateBigPhoto(position, progress)
        updateSmallPhoto(progress)
        updateButtons(progress)
        updateArrow(progress)
    }

    private fun updateArrow(progress: Float) {
        details.rotation = 180 * progress / 100
    }

    private fun updateButtons(progress: Float) {
        listOf(buttonS, buttonM, buttonL, buttonXL).forEach {
            val layoutParams = it.layoutParams

            layoutParams.width = (progress / 100 * dimen30 + dimen50).toInt()
            layoutParams.height = (progress / 100 * dimen30 + dimen50).toInt()

            it.layoutParams = layoutParams;
        }
    }

    fun updateSmallPhoto(progress: Float) {
        val layoutParams = smallPhoto.layoutParams as LinearLayout.LayoutParams
        layoutParams.width = (dimen100 * progress / 100).toInt()
        layoutParams.height = (dimen130 * progress / 100).toInt()

        smallPhoto.layoutParams = layoutParams

        val smallPhotoProgress = (progress - SMALL_PHOTO_ANIMATION_START) / (100f - SMALL_PHOTO_ANIMATION_START)

        smallPhoto.visibility = if (progress > SMALL_PHOTO_ANIMATION_START) View.VISIBLE else View.INVISIBLE
        smallPhoto.alpha = if (progress > SMALL_PHOTO_ANIMATION_START) 0.4f * smallPhotoProgress + 0.6f else 1f
        smallPhoto.scaleX = if (progress > SMALL_PHOTO_ANIMATION_START) 0.7f * smallPhotoProgress + 0.3f else 1f
        smallPhoto.scaleY = if (progress > SMALL_PHOTO_ANIMATION_START) 0.7f * smallPhotoProgress + 0.3f else 1f
    }

    fun updateBigPhoto(position: Int, progress: Float) {
        if (progress < PHOTO_ANIMATION_START) {
            val layoutParams = photo.layoutParams
            layoutParams.height = (appBar!!.height + position)
            photo.layoutParams = layoutParams

            val tanX = -photo.width * progress / 200
            photo.translationX = tanX
        }
        photo.alpha = 1 - (progress / 100)

        val photoProgress = (progress - PHOTO_ANIMATION_START) / (100f - PHOTO_ANIMATION_START)

        val tranzY = if (progress > PHOTO_ANIMATION_START) photoProgress * photo.height else 0f
        photo.translationY = tranzY * 1.1f

        photo.scaleX = if (progress > PHOTO_ANIMATION_START) 0.7f * (1 - photoProgress) + 0.3f else 1f
        photo.scaleY = if (progress > PHOTO_ANIMATION_START) 0.7f * (1 - photoProgress) + 0.3f else 1f
    }
}




