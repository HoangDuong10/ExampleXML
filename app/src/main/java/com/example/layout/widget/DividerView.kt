package com.example.layout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.layout.R

class DividerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    companion object {
        const val ORIENTATION_HORIZONTAL = 0
        const val ORIENTATION_VERTICAL = 1
    }

    private val mPaint: Paint
    private var orientation: Int

    init {
        val dashGap: Int
        val dashLength: Int
        val dashThickness: Int
        val color: Int

        context.theme.obtainStyledAttributes(attrs, R.styleable.DividerView, 0, 0).apply {
            try {
                dashGap = getDimensionPixelSize(R.styleable.DividerView_dashGap, 5)
                dashLength = getDimensionPixelSize(R.styleable.DividerView_dashLength, 5)
                dashThickness = getDimensionPixelSize(R.styleable.DividerView_dashThickness, 3)
                color = getColor(R.styleable.DividerView_color, 0xff000000.toInt())
                orientation = getInt(R.styleable.DividerView_orientation, ORIENTATION_HORIZONTAL)
            } finally {
                recycle()
            }
        }

        mPaint = Paint().apply {
            isAntiAlias = true
            this.color = color
            style = Paint.Style.STROKE
            strokeWidth = dashThickness.toFloat()
            pathEffect = DashPathEffect(floatArrayOf(dashLength.toFloat(), dashGap.toFloat()), 0f)
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (orientation == ORIENTATION_HORIZONTAL) {
            val center = height * 0.5f
            canvas.drawLine(0f, center, width.toFloat(), center, mPaint)
        } else {
            val center = width * 0.5f
            canvas.drawLine(center, 0f, center, height.toFloat(), mPaint)
        }
    }
}