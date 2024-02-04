package com.slyene.calories.ui.dishes

import com.slyene.calories.data.Dish

data class DishesUiState(
    val dishesList: List<Dish> = mutableListOf()
)
