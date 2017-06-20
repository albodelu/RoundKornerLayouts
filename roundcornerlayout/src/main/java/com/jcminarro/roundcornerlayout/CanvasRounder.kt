package com.jcminarro.roundcornerlayout

import android.graphics.Canvas

class CanvasRounder(val cornerRadius: Float) {
    private val path = android.graphics.Path()

    fun round(canvas: Canvas, drawFuncion: (Canvas) -> Unit){
        if (cornerRadius != NO_CORNER_RADIUS) {
            val save = canvas.save()
            canvas.clipPath(path)
            drawFuncion(canvas)
            canvas.restoreToCount(save)
        } else {
            drawFuncion(canvas)
        }
    }

    fun updateSize(currentWidth: Int, currentHeight: Int) {
        path.reset()
        val rectF = android.graphics.RectF(0f, 0f, currentWidth.toFloat(), currentHeight.toFloat())
        path.addRoundRect(rectF, cornerRadius, cornerRadius, android.graphics.Path.Direction.CW)
        path.close()
    }

    companion object {
        const val NO_CORNER_RADIUS = 0f
    }
}