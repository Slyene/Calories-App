package com.slyene.calories

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.data.Dish
import com.slyene.calories.ui.dishes.DishesScreen
import com.slyene.calories.ui.dishes.DishesViewModel

@Composable
fun CaloriesApp() {
    val dishesViewModel: DishesViewModel = viewModel()
    DishesScreen(
        viewModel = dishesViewModel,
        onFabClick = { dishesViewModel.changeDialogShowState() },
        onDishClick = { dishesViewModel.changeDialogShowState() },
        onSaveClick = {
            dishesViewModel.saveToLocalStorage(it)
            dishesViewModel.changeDialogShowState()
        }
    )
}