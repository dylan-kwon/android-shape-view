package dylan.kwon.shapeview.component.factory

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import dylan.kwon.shapeview.component.RippleComponent

interface RippleFactory {

    fun create(
        background: GradientDrawable,
        ripple: RippleComponent,
    ): RippleDrawable?

}

object DefaultRippleFactory : RippleFactory {

    override fun create(
        background: GradientDrawable,
        ripple: RippleComponent,
    ): RippleDrawable? {
        if (!ripple.enabled) {
            return null
        }
        return when (val rippleColor = ripple.color) {
            null -> null
            else -> RippleDrawable(
                rippleColor, null, background.toMask()
            )
        }
    }

    private fun GradientDrawable.toMask(): GradientDrawable {
        color = ColorStateList(
            arrayOf(
                intArrayOf()
            ),
            intArrayOf(
                Color.WHITE
            )
        )
        return this
    }
}