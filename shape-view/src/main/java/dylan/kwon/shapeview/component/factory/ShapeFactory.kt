package dylan.kwon.shapeview.component.factory

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import dylan.kwon.shapeview.component.CornerComponent
import dylan.kwon.shapeview.component.GradientComponent
import dylan.kwon.shapeview.component.StrokeComponent
import dylan.kwon.shapeview.constant.gradientOrientationOf

interface ShapeFactory {

    fun create(
        color: ColorStateList?,
        corner: CornerComponent,
        stroke: StrokeComponent,
        gradient: GradientComponent,
    ): GradientDrawable

}

object DefaultShapeFactory : ShapeFactory {

    override fun create(
        color: ColorStateList?,
        corner: CornerComponent,
        stroke: StrokeComponent,
        gradient: GradientComponent
    ): GradientDrawable = GradientDrawable().apply {
        this.shape = GradientDrawable.RECTANGLE
        this.color = color
        this.cornerRadii = corner.getRadius()
        this.setStroke(
            stroke.width.toInt(),
            stroke.color,
            stroke.dashWidth,
            stroke.dashGap
        )
        if (gradient.type > -1) {
            this.colors = gradient.colors
            this.gradientType = gradient.type
            this.gradientRadius = gradient.radius
            this.orientation = gradientOrientationOf(gradient.orientation)

            this.setGradientCenter(gradient.x, gradient.y)
        }
    }
}