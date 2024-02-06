package com.slyene.calories.ui.dishes

import com.slyene.calories.data.Dish

data class DishesListUiState(
    val dishesList: List<Dish> = emptyList(),
)

data class DishesUiState(
    val selectedDish: Int = 0,
    val showDialog: Boolean = false
)