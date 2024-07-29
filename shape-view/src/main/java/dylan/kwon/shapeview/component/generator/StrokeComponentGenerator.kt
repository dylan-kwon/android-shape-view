package dylan.kwon.shapeview.component.generator

import android.content.res.TypedArray
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.component.StrokeComponent

fun StrokeComponent.Companion.of(typedArray: TypedArray) = StrokeComponent(
    width = typedArray.getDimension(
        R.styleable.ShapeView_strokeWidth, 0f
    ),
    dashWidth = typedArray.getDimension(
        R.styleable.ShapeView_strokeDashWidth, 0f
    ),
    dashGap = typedArray.getDimension(
        R.styleable.ShapeView_strokeDashGap, 0f
    ),
    color = typedArray.getColorStateList(
        R.styleable.ShapeView_strokeColor
    ),
)