package com.gms.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gms.core.R
import com.gms.core.domain.preferences.Preferences
import com.gms.core.domain.use_case.FilterOutDigits
import com.gms.core.navigation.Route
import com.gms.core.util.UiEvent
import com.gms.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {
    var age by mutableStateOf("18")
        private set

    private val _uiState = Channel<UiEvent>()
    val uiState = _uiState.receiveAsFlow()

    fun onAgeEnter(age: String) {
        if (age.length <= 3) {
            this.age = filterOutDigits(age)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiState.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.txt_error_age_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiState.send(UiEvent.Navigate(route = Route.HEIGHT))
        }
    }
}