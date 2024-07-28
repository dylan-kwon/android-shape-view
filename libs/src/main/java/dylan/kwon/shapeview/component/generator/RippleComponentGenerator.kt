package dylan.kwon.shapeview.component.generator

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.TypedValue
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.component.RippleComponent

fun RippleComponent.Companion.of(
    context: Context,
    typedArray: TypedArray,
): RippleComponent {
    val rippleEnabled = typedArray.getBoolean(
        R.styleable.ShapeView_rippleEnabled, true
    )
    var rippleColor: ColorStateList? = typedArray.getColorStateList(
        R.styleable.ShapeView_rippleColor
    )
    if (rippleEnabled && rippleColor == null) {
        rippleColor = getDefaultRippleColor(context)
    }
    return RippleComponent(
        enabled = rippleEnabled,
        color = rippleColor
    )
}

private fun getDefaultRippleColor(context: Context): ColorStateList? {
    try {
        val typedValue = TypedValue()
        val isResolved = context.theme.resolveAttribute(
            androidx.appcompat.R.attr.colorControlHighlight,
            typedValue,
            true
        )
        if (!isResolved) {
            throw Exception()
        }
        return ColorStateList(
            arrayOf(
                intArrayOf()
            ),
            intArrayOf(
                typedValue.data
            )
        )
    } catch (e: Exception) {
        return null
    }
}