package com.example.weather_app.sta.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.weather_app.R
import kotlin.math.min

class InfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var TimeText: String? = null
    private var UVText: String? = null
    private var RainText: String? = null
    private var AQText: String? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.InfoView, defStyleAttr, 0) // получаем массив атрибутов typedArray из контекста
        TimeText = typedArray.getString(R.styleable.InfoView_TimeText)
        UVText = typedArray.getString(R.styleable.InfoView_UVText)
        RainText = typedArray.getString(R.styleable.InfoView_RainText)
        AQText = typedArray.getString(R.styleable.InfoView_AQText)

        typedArray.recycle() // освобождаем ресурсы
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 329 // Предполагаемая ширина View
        val desiredHeight = 59 // Предполагаемая высота View

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize // Задан конкретный размер для ширины
            MeasureSpec.AT_MOST -> min(
                desiredWidth,
                widthSize
            ) // Размер не должен превышать заданный размер
            else -> desiredWidth // Задать предпочтительный размер, если точного или максимального размера не задано
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize // Задан конкретный размер для высоты
            MeasureSpec.AT_MOST -> min(
                desiredHeight,
                heightSize
            ) // Размер не должен превышать заданный размер
            else -> desiredHeight // Задать предпочтительный размер, если точного или максимального размера не задано
        }

        setMeasuredDimension(width, height) // Устанавливаем фактический размер View
    }

    private val paint = Paint()

    class MyCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
        private val fillPaint = Paint().apply {
            color = Color.RED
            style = Paint.Style.FILL
        }

        private val textPaint = Paint().apply {
            color = Color.parseColor("FDFCFC")
            style = Paint.Style.STROKE
            strokeWidth = 10f
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            // Рисуем прямоугольник на Canvas
            canvas.drawRect(50f, 50f, 200f, 200f, fillPaint)



        }
    }
}