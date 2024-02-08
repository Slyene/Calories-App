package com.slyene.calories

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.ui.AddDishFab
import com.slyene.calories.ui.CaloriesNavigationBar
import com.slyene.calories.ui.dishes.DishesScreen
import com.slyene.calories.ui.dishes.DishesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloriesApp() {
    val dishesViewModel: DishesViewModel = viewModel()

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
            AddDishFab {
                dishesViewModel.selectDish(0)
                dishesViewModel.changeDialogShowState()
            }
        }
    ) {
        DishesScreen(
            modifier = Modifier.padding(it),
            viewModel = dishesViewModel,
            onDishClick = { dishId ->
                dishesViewModel.selectDish(dishId)
                dishesViewModel.changeDialogShowState()
            },
            onSaveClick = { dish ->
                //dishesViewModel.saveToLocalStorage(dish)
                dishesViewModel.changeDialogShowState()
            }
        )
    }
}