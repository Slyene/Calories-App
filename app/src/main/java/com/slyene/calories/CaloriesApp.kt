package com.slyene.calories

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.slyene.calories.ui.CaloriesDestinations
import com.slyene.calories.ui.CaloriesFab
import com.slyene.calories.ui.CaloriesNavHost
import com.slyene.calories.ui.CaloriesNavigationBar
import com.slyene.calories.ui.CaloriesTopAppBar
import com.slyene.calories.ui.dishes.DishesFullscreenDialogViewModel
import com.slyene.calories.ui.dishes.DishesViewModel

@Composable
fun CaloriesApp() {
    val dishesViewModel: DishesViewModel = viewModel()
    val dishesDialogViewModel: DishesFullscreenDialogViewModel = viewModel()
    val navController = rememberNavController()

    val currentScreen by remember { mutableStateOf(CaloriesDestinations.Statistics) }

    Scaffold(
        topBar = {
            CaloriesTopAppBar(canNavigateBack = true, currentScreen = currentScreen)
        },
        bottomBar = {
            CaloriesNavigationBar(navController = navController)
        },
        floatingActionButton = {
            CaloriesFab(icon = ImageVector.vectorResource(id = R.drawable.rounded_add_24)) {
                dishesViewModel.selectDish(null)
                dishesViewModel.changeDialogShowState()
            }
        }
    ) {
        CaloriesNavHost(
            dishesViewModel = dishesViewModel,
            dishesDialogViewModel = dishesDialogViewModel,
            navController = navController,
            startDestination = CaloriesDestinations.Statistics.route,
            modifier = Modifier.padding(it)
        )
    }
}