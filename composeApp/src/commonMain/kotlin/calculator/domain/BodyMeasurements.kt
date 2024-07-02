package calculator.domain

/**
 * @author   RoRR <rollolpindo@gmail.com>
 * @since    02/07/2024
 */
data class BodyMeasurements(
    val heightCm: Float,
    val weightKg: Float,
) {
    fun toBMI(): Float = weightKg / (heightCm * heightCm * 0.0001f)
}
