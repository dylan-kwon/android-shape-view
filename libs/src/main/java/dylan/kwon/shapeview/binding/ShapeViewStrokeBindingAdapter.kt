package dylan.kwon.shapeview.binding

import android.content.res.ColorStateList
import androidx.databinding.BindingAdapter
import dylan.kwon.shapeview.ShapeView

object ShapeViewStrokeBindingAdapter {

    @JvmStatic
    @BindingAdapter("strokeWidth")
    fun ShapeView.setStrokeWidth(width: Float) {
        stroke = stroke.copy(
            width = width
        )
    }

    @JvmStatic
    @BindingAdapter("strokeDashWidth")
    fun ShapeView.setStrokeDashWidth(width: Float) {
        stroke = stroke.copy(
            dashWidth = width
        )
    }

    @JvmStatic
    @BindingAdapter("strokeDashGap")
    fun ShapeView.setStrokeDashGap(gap: Float) {
        stroke = stroke.copy(
            dashGap = gap
        )
    }

    @JvmStatic
    @BindingAdapter("strokeColor")
    fun ShapeView.setStrokeColor(color: ColorStateList?) {
        stroke = stroke.copy(
            color = color
        )
    }

}
