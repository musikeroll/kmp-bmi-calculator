package calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author   RoRR <rollolpindo@gmail.com>
 * @since    02/07/2024
 */
@Composable
fun BMIBackdropView(
    modifier: Modifier,
    color: Color
) {
    Box(modifier = modifier.background(color = color))
}

@Preview
@Composable
fun BMIBackdropViewPreview() {
    BMIBackdropView(modifier = Modifier.fillMaxWidth(), Color.Red)
}