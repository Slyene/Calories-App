package com.slyene.calories.ui.dishes

import com.slyene.calories.data.Dish

data class DishesFullscreenDialogUiState(
    val item: Dish = Dish(),
    val isInvalidInput: Boolean = true
)
