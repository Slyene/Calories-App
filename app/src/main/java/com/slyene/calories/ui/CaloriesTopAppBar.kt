package com.slyene.calories.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloriesTopAppBar(
    canNavigateBack: Boolean,
    currentScreen: CaloriesDestinations
) {
    TopAppBar(title = { currentScreen.title })
}