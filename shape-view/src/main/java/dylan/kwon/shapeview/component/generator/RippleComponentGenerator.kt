package dylan.kwon.shapeview.component.generator

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
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
        rippleColor = context.getColorStateList(R.color.default_ripple_color)
    }
    return RippleComponent(
        enabled = rippleEnabled,
        color = rippleColor
    )
}