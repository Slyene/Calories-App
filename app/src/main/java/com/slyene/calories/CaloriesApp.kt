package com.slyene.calories

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.ui.dishes.DishesScreen

@Composable
fun CaloriesApp() {
    DishesScreen(
        viewModel = viewModel(),
        onFabClick = { },
        onDishClick = {}
    )
}