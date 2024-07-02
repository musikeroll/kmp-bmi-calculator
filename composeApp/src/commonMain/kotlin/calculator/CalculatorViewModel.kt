package calculator

import androidx.compose.ui.graphics.Color
import calculator.domain.BodyMeasurements
import calculator.utils.roundToNNearestHalf
import calculator.utils.roundUpToNearestInteger
import calculator.utils.toBMIColor
import calculator.utils.toFormattedString
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * @author   RoRR <rollolpindo@gmail.com>
 * @since    02/07/2024
 */
class CalculatorViewModel : ViewModel() {

    private var _uistate = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState>
        get() = _uistate

    init {
        updateUIState(_uistate.value.bodyMeasurements)
    }

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.ChangeHeight -> updateUIState(
                _uistate.value.bodyMeasurements.copy(heightCm = event.heightCm)
            )

            is UIEvent.ChangeWeight -> updateUIState(
                _uistate.value.bodyMeasurements.copy(weightKg = event.weightKg)
            )
        }
    }

    private fun updateUIState(bodyMeasurements: BodyMeasurements) {
        _uistate.update { state ->
            val bmi = bodyMeasurements.toBMI()
            state.copy(
                bodyMeasurements = bodyMeasurements,
                bmiDisplay = bmi.toFormattedString(),
                heightDisplay = bodyMeasurements.heightCm.roundUpToNearestInteger().toString(),
                weightDisplay = bodyMeasurements.weightKg.roundToNNearestHalf().toString(),
                accentColor = bmi.toBMIColor()
            )
        }
    }

    sealed class UIEvent {
        data class ChangeHeight(val heightCm: Float) : UIEvent()
        data class ChangeWeight(val weightKg: Float) : UIEvent()
    }

    data class UIState(
        val bodyMeasurements: BodyMeasurements = BodyMeasurements(170f, 60f),
        val bmiDisplay: String = "",
        val heightDisplay: String = "",
        val weightDisplay: String = "",
        val accentColor: Color = Color.Blue
    )
}