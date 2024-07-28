package dylan.kwon.shapeview.component.generator

import android.content.res.TypedArray
import android.graphics.Color
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.component.GradientComponent
import dylan.kwon.shapeview.constant.GradientOrientation

fun GradientComponent.Companion.of(typedArray: TypedArray) = GradientComponent(
    type = typedArray.getInt(
        R.styleable.ShapeView_gradientType, -1
    ),
    startColor = typedArray.getColor(
        R.styleable.ShapeView_gradientStartColor, Color.TRANSPARENT
    ),
    centerColor = typedArray.getColor(
        R.styleable.ShapeView_gradientCenterColor, -1
    ),
    endColor = typedArray.getColor(
        R.styleable.ShapeView_gradientEndColor, Color.TRANSPARENT
    ),
    radius = typedArray.getDimension(
        R.styleable.ShapeView_gradientRadius, 0.0f
    ),
    x = typedArray.getFloat(
        R.styleable.ShapeView_gradientX, 0.5f
    ),
    y = typedArray.getFloat(
        R.styleable.ShapeView_gradientY, 0.5f
    ),
    orientation = typedArray.getInt(
        R.styleable.ShapeView_gradientOrientation, GradientOrientation.LEFT_RIGHT
    ),
)

