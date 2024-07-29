package dylan.kwon.shapeview.component

import android.content.res.ColorStateList

data class RippleComponent(
    val color: ColorStateList? = null,
    val enabled: Boolean = false
) {
    companion object
}