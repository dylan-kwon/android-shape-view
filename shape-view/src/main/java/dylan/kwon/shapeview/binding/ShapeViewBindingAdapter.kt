package dylan.kwon.shapeview.binding

import android.content.res.ColorStateList
import androidx.databinding.BindingAdapter
import dylan.kwon.shapeview.ShapeView

object ShapeViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("solidColor")
    fun ShapeView.setSolidColor(color: ColorStateList?) {
        this.solidColor = color
    }

    @JvmStatic
    @BindingAdapter("useClip")
    fun ShapeView.setUseClip(useClip: Boolean) {
        this.useClip = useClip
    }
}
