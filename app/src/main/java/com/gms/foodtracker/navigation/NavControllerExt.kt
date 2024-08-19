package com.gms.foodtracker.navigation

import androidx.navigation.NavController
import com.gms.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}