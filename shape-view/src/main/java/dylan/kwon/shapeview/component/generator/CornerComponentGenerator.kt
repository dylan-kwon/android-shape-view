package dylan.kwon.shapeview.component.generator

import android.content.res.TypedArray
import dylan.kwon.shapeview.R
import dylan.kwon.shapeview.component.CornerComponent

fun CornerComponent.Companion.of(typedArray: TypedArray): CornerComponent {
    val cornerRadius = typedArray.getDimension(
        R.styleable.ShapeView_cornerRadius, -1f
    )
    if (cornerRadius > -1) {
        return CornerComponent(
            topLeftRadius = cornerRadius,
            topRightRadius = cornerRadius,
            bottomLeftRadius = cornerRadius,
            bottomRightRadius = cornerRadius
        )
    }
    return CornerComponent(
        topLeftRadius = typedArray.getDimension(
            R.styleable.ShapeView_topLeftRadius, 0f
        ),
        topRightRadius = typedArray.getDimension(
            R.styleable.ShapeView_topRightRadius, 0f
        ),
        bottomLeftRadius = typedArray.getDimension(
            R.styleable.ShapeView_bottomLeftRadius, 0f
        ),
        bottomRightRadius = typedArray.getDimension(
            R.styleable.ShapeView_bottomRightRadius, 0f
        )
    )
}