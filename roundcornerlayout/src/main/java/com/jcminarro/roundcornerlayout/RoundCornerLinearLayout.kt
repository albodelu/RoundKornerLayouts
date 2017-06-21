package com.jcminarro.roundcornerlayout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

class RoundCornerLinearLayout
    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {
    private val canvasRounder: CanvasRounder

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerLinearLayout, 0, 0)
        val cornerRadius = array.getDimension(R.styleable.RoundCornerFrameLayout_corner_radius, 0f)
        array.recycle()
        canvasRounder = CanvasRounder(cornerRadius)
    }

    override fun onSizeChanged(currentWidth: Int, currentHeight: Int, oldWidth: Int, oldheight: Int) {
        super.onSizeChanged(currentWidth, currentHeight, oldWidth, oldheight)
        canvasRounder.updateSize(currentWidth, currentHeight)
    }

    override fun draw(canvas: Canvas) = canvasRounder.round(canvas) { super.draw(canvas) }

    override fun dispatchDraw(canvas: Canvas) = canvasRounder.round(canvas) { super.dispatchDraw(canvas)}
}