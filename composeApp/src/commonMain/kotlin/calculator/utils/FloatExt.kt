package calculator.utils

import androidx.compose.ui.graphics.Color
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

/**
 * @author   RoRR <rollolpindo@gmail.com>
 * @since    02/07/2024
 */
fun Float.roundUpToNearestInteger(): Int = (this + 0.5f).toInt()

fun Float.roundToNNearestHalf(): Float = (this * 2f).roundToInt() / 2.0f

fun Float.toFormattedString(decimals: Int = 2): String {
    val multiplier = 10.toFloat().pow(decimals)
    val rounded = round(this * multiplier) / multiplier
    return rounded.toString()
}

fun Float.toBMIColor(): Color =
    when {
        (this < 18.5f) -> Color(0xFF00CEE6) // Underweight
        (this < 25.0f) -> Color(0xFF96DC3E) // Normal Weight
        (this < 30.0f) -> Color(0xFFF4BD40) // Overweight
        (this < 35.0f) -> Color(0xFFEE7D29) // Obesity, Class I
        (this < 49.0f) -> Color(0xFFED5321) // Obesity, Class II
        else -> Color(0xFFED5321)           // Obesity, Class III
    }