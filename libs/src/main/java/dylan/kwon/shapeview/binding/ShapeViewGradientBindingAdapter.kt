package dylan.kwon.shapeview.binding

import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import dylan.kwon.shapeview.ShapeView

object ShapeViewGradientBindingAdapter {

    @JvmStatic
    @BindingAdapter("gradientType")
    fun ShapeView.setGradientType(type: Int) {
        gradient = gradient.copy(
            type = type
        )
    }

    @JvmStatic
    @BindingAdapter("gradientStartColor")
    fun ShapeView.setGradientStartColor(@ColorInt color: Int) {
        gradient = gradient.copy(
            startColor = color
        )
    }

    @JvmStatic
    @BindingAdapter("gradientCenterColor")
    fun ShapeView.setGradientCenterColor(@ColorInt color: Int) {
        gradient = gradient.copy(
            centerColor = color
        )
    }

    @JvmStatic
    @BindingAdapter("gradientEndColor")
    fun ShapeView.setGradientEndColor(@ColorInt color: Int) {
        gradient = gradient.copy(
            endColor = color
        )
    }

    @JvmStatic
    @BindingAdapter("gradientRadius")
    fun ShapeView.setGradientRadius(radius: Float) {
        gradient = gradient.copy(
            radius = radius
        )
    }

    @JvmStatic
    @BindingAdapter("gradientX")
    fun ShapeView.setGradientX(x: Float) {
        gradient = gradient.copy(
            x = x
        )
    }

    @JvmStatic
    @BindingAdapter("gradientY")
    fun ShapeView.setGradientY(y: Float) {
        gradient = gradient.copy(
            y = y
        )
    }

    @JvmStatic
    @BindingAdapter("gradientOrientation")
    fun ShapeView.setGradientOrientation(orientation: Int) {
        gradient = gradient.copy(
            orientation = orientation
        )
    }

}
