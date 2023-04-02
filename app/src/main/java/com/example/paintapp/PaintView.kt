package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path


class PaintView : View {
    var params : ViewGroup.LayoutParams? = null //this sets the canvas with respect to the height and width of the parent layout
    //constructor for class extended from view
    companion object{
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()//color we have have type of INt
        var currentBrush = Color.BLACK;//this is the default color of the brush set
    }
    constructor(context: Context): this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    private fun init(){
        paintBrush.isAntiAlias = true // this makes the strokes smooth
        paintBrush.color = currentBrush //sets the default color of brush to black
        paintBrush.style = Paint.Style.STROKE//sets the brush style to a stroke
        paintBrush.strokeJoin = Paint.Join.ROUND//the end of the stroke will be round
        paintBrush.strokeWidth = 8f; // the size of the brush is set

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    //how to get the draws of user on the screen
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }

        postInvalidate()//notifies the program that changes have been made to the UI
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()//also informs program about changes to the UI
        }
    }
}