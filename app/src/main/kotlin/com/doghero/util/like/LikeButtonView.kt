package com.doghero.util.like

import android.animation.Animator
import android.view.MotionEvent
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.view.LayoutInflater
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import com.doghero.R
import kotlinx.android.synthetic.main.view_like_button.view.*

class LikeButtonView : FrameLayout, View.OnClickListener {
    private var isChecked: Boolean = true
    private var animatorSet: AnimatorSet? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.view_like_button, this, true)
        setOnClickListener(this)
    }

    override fun onClick(v: View) {
        isChecked = !isChecked
        imageView!!.setImageResource(if (isChecked) R.drawable.icon_like_select else R.drawable.icon_like_unselected)

        if (animatorSet != null) {
            animatorSet!!.cancel()
        }

        if (isChecked) {
            imageView!!.animate().cancel()
            imageView!!.scaleX = 0f
            imageView!!.scaleY = 0f

            animatorSet = AnimatorSet()


            val starScaleYAnimator = ObjectAnimator.ofFloat(imageView, ImageView.SCALE_Y, 0.2f, 1f)
            starScaleYAnimator.duration = 350
            starScaleYAnimator.startDelay = 250
            starScaleYAnimator.interpolator = OVERSHOOT_INTERPOLATOR

            val starScaleXAnimator = ObjectAnimator.ofFloat(imageView, ImageView.SCALE_X, 0.2f, 1f)
            starScaleXAnimator.duration = 350
            starScaleXAnimator.startDelay = 250
            starScaleXAnimator.interpolator = OVERSHOOT_INTERPOLATOR


            animatorSet!!.playTogether(
                starScaleYAnimator,
                starScaleXAnimator
            )

            animatorSet!!.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationCancel(animation: Animator) {
                    imageView!!.scaleX = 1F
                    imageView!!.scaleY = 1F
                }
            })

            animatorSet!!.start()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                imageView!!.animate().scaleX(0.7f).scaleY(0.7f).setDuration(150).interpolator = DECCELERATE_INTERPOLATOR
                isPressed = true
            }

            MotionEvent.ACTION_MOVE -> {
                val x = event.x
                val y = event.y
                val isInside = x > 0 && x < width && y > 0 && y < height
                if (isPressed != isInside) {
                    isPressed = isInside
                }
            }

            MotionEvent.ACTION_UP -> {
                imageView!!.animate().scaleX(1F).scaleY(1F).interpolator = DECCELERATE_INTERPOLATOR
                if (isPressed) {
                    performClick()
                    isPressed = false
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                imageView!!.animate().scaleX(1F).scaleY(1F).interpolator = DECCELERATE_INTERPOLATOR
                isPressed = false
            }
        }
        return true
    }

    companion object {
        private val DECCELERATE_INTERPOLATOR = DecelerateInterpolator()
        private val OVERSHOOT_INTERPOLATOR = OvershootInterpolator(4f)
    }
}