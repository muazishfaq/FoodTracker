package com.gms.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gms.core.domain.model.Gender
import com.gms.core.domain.preferences.Preferences
import com.gms.core.navigation.Route
import com.gms.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {
    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _uiState = Channel<UiEvent>()
    val uiState = _uiState.receiveAsFlow()


    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiState.send(UiEvent.Navigate(route = Route.AGE))
        }

    }
}