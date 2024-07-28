package dylan.kwon.shapeview.binding

import android.content.res.ColorStateList
import androidx.databinding.BindingAdapter
import dylan.kwon.shapeview.ShapeView

object ShapeViewRippleBindingAdapter {

    @JvmStatic
    @BindingAdapter("rippleColor")
    fun ShapeView.setRippleColor(color: ColorStateList?) {
        ripple = ripple.copy(
            color = color
        )
    }

    @JvmStatic
    @BindingAdapter("rippleEnabled")
    fun ShapeView.setRippleColor(enabled: Boolean) {
        ripple = ripple.copy(
            enabled = enabled
        )
    }
}
