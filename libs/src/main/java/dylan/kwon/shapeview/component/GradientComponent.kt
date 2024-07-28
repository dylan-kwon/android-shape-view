package dylan.kwon.shapeview.component

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import dylan.kwon.shapeview.constant.toInt

data class GradientComponent(
    var type: Int = GradientDrawable.LINEAR_GRADIENT,
    var startColor: Int = Color.TRANSPARENT,
    var centerColor: Int = -1,
    var endColor: Int = Color.TRANSPARENT,
    var radius: Float = 0f,
    var x: Float = 0.5f,
    var y: Float = 0.5f,
    var orientation: Int = GradientDrawable.Orientation.LEFT_RIGHT.toInt(),
) {

    companion object

    val colors: IntArray
        get() = mutableListOf<Int>().apply {
            this += startColor
            if (centerColor != -1) {
                this += centerColor
            }
            this += endColor
        }.toIntArray()
}