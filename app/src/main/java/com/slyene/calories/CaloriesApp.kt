package com.slyene.calories

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.ui.CaloriesFab
import com.slyene.calories.ui.CaloriesNavigationBar
import com.slyene.calories.ui.dishes.DishesFullscreenDialogViewModel
import com.slyene.calories.ui.dishes.DishesScreen
import com.slyene.calories.ui.dishes.DishesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloriesApp() {
    val dishesViewModel: DishesViewModel = viewModel()
    val dishesDialogViewModel: DishesFullscreenDialogViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") },
            )
        },
        bottomBar = {
            CaloriesNavigationBar()
        },
        floatingActionButton = {
            CaloriesFab(icon = Icons.Default.Add) {
                dishesViewModel.selectDish(0)
                dishesViewModel.changeDialogShowState()
            }
        }
    ) {
        DishesScreen(
            modifier = Modifier.padding(it),
            viewModel = dishesViewModel,
            dishesDialogViewModel = dishesDialogViewModel,
            onDishClick = { dishId ->
                dishesViewModel.selectDish(dishId)
                dishesViewModel.changeDialogShowState()
            },
            onSaveClick = {
                dishesDialogViewModel.saveDishToLocalStorage()
                dishesViewModel.changeDialogShowState()
            }
        )
    }
}