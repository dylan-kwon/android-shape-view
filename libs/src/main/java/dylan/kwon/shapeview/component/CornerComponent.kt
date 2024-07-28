package dylan.kwon.shapeview.component


data class CornerComponent(
    val topLeftRadius: Float = 0f,
    val topRightRadius: Float = 0f,
    val bottomLeftRadius: Float = 0f,
    val bottomRightRadius: Float = 0f
) {
    companion object

    fun getRadius(): FloatArray = floatArrayOf(
        topLeftRadius,
        topLeftRadius,
        topRightRadius,
        topRightRadius,
        bottomLeftRadius,
        bottomLeftRadius,
        bottomRightRadius,
        bottomRightRadius
    )

    fun setRadius(cornerRadius: Float) = copy(
        topLeftRadius = cornerRadius,
        topRightRadius = cornerRadius,
        bottomLeftRadius = cornerRadius,
        bottomRightRadius = cornerRadius
    )
}