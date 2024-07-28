package dylan.kwon.shapeview.binding

import androidx.databinding.BindingAdapter
import dylan.kwon.shapeview.ShapeView

object ShapeViewCornerBindingAdapter {

    @JvmStatic
    @BindingAdapter("cornerRadius")
    fun ShapeView.setCornerRadius(radius: Float) {
        corner = corner.copy(
            topLeftRadius = radius,
            topRightRadius = radius,
            bottomLeftRadius = radius,
            bottomRightRadius = radius
        )
    }

    @JvmStatic
    @BindingAdapter("topLeftRadius")
    fun ShapeView.setTopLeftRadius(radius: Float) {
        corner = corner.copy(
            topLeftRadius = radius
        )
    }

    @JvmStatic
    @BindingAdapter("topRightRadius")
    fun ShapeView.setTopRightRadius(radius: Float) {
        corner = corner.copy(
            topRightRadius = radius
        )
    }

    @JvmStatic
    @BindingAdapter("bottomLeftRadius")
    fun ShapeView.setBottomLeftRadius(radius: Float) {
        corner = corner.copy(
            bottomLeftRadius = radius
        )
    }

    @JvmStatic
    @BindingAdapter("bottomRightRadius")
    fun ShapeView.setBottomRightRadius(radius: Float) {
        corner = corner.copy(
            bottomRightRadius = radius
        )
    }

}
