package dylan.kwon.shapeview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.res.use
import dylan.kwon.shapeview.component.CornerComponent
import dylan.kwon.shapeview.component.GradientComponent
import dylan.kwon.shapeview.component.RippleComponent
import dylan.kwon.shapeview.component.StrokeComponent
import dylan.kwon.shapeview.component.factory.DefaultRippleFactory
import dylan.kwon.shapeview.component.factory.DefaultShapeFactory
import dylan.kwon.shapeview.component.factory.RippleFactory
import dylan.kwon.shapeview.component.factory.ShapeFactory
import dylan.kwon.shapeview.component.generator.of

class ShapeView @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0

) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    var solidColor: ColorStateList? = null
        set(value) {
            field = value
            invalidateShape()
        }

    var useClip: Boolean = false
        set(value) {
            field = value
            invalidateShape()
        }

    var stroke: StrokeComponent = StrokeComponent()
        set(value) {
            field = value
            invalidateShape()
        }

    var corner: CornerComponent = CornerComponent()
        set(value) {
            field = value
            invalidateShape()
        }

    var ripple: RippleComponent = RippleComponent()
        set(value) {
            field = value
            invalidateShape()
        }

    var gradient: GradientComponent = GradientComponent()
        set(value) {
            field = value
            invalidateShape()
        }

    private val shapeFactory: ShapeFactory = DefaultShapeFactory
    private val rippleFactory: RippleFactory = DefaultRippleFactory

    init {
        context.obtainStyledAttributes(
            attrs, R.styleable.ShapeView, defStyleAttr, defStyleRes
        ).use { typedArray ->
            solidColor = typedArray.getColorStateList(
                R.styleable.ShapeView_solidColor
            )
            useClip = typedArray.getBoolean(
                R.styleable.ShapeView_useClip, false
            )
            corner = CornerComponent.of(typedArray)
            ripple = RippleComponent.of(context, typedArray)
            stroke = StrokeComponent.of(typedArray)
            gradient = GradientComponent.of(typedArray)
        }
    }

    private fun invalidateShape() {
        fun createBackground() = shapeFactory.create(
            color = solidColor,
            corner = corner,
            stroke = stroke,
            gradient = gradient
        )
        background = createBackground()
        foreground = rippleFactory.create(createBackground(), ripple)
    }

    override fun draw(canvas: Canvas) {
        if (useClip) {
            canvas.clip()
        }
        super.draw(canvas)
    }

    private fun Canvas.clip() {
        val clipPath = Path().apply {
            addRoundRect(
                RectF(clipBounds), corner.getRadius(), Path.Direction.CW
            )
        }
        clipPath(clipPath)
    }
}