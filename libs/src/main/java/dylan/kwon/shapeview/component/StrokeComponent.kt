package dylan.kwon.shapeview.component

import android.content.res.ColorStateList

data class StrokeComponent(
    val width: Float = 0f,
    val dashWidth: Float = 0f,
    val dashGap: Float = 0f,
    val color: ColorStateList? = null,
) {
    companion object
}