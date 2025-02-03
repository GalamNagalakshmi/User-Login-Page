package com.example.task2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class CircleView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private var circlePaint: Paint? = null
    private var textPaint: Paint? = null
    private var number = "1" // Default number

    init {
        init()
    }

    private fun init() {
        circlePaint = Paint()
        circlePaint!!.color = Color.BLUE
        circlePaint!!.isAntiAlias = true

        textPaint = Paint()
        textPaint!!.color = Color.WHITE
        textPaint!!.textSize = 64f
        textPaint!!.isAntiAlias = true
        textPaint!!.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()
        val radius = (min(centerX.toDouble(), centerY.toDouble()) - 10).toFloat()


        canvas.drawCircle(centerX, centerY, radius, circlePaint!!)
        canvas.drawText(number, centerX, centerY + textPaint!!.textSize / 3, textPaint!!)
    }

    fun setNumber(number: String) {
        this.number = number
        invalidate()
    }
}
