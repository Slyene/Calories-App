package com.slyene.calories.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.slyene.calories.R
import com.slyene.calories.ui.dishes.DishesFullscreenDialogViewModel
import com.slyene.calories.ui.dishes.DishesScreen
import com.slyene.calories.ui.dishes.DishesViewModel

sealed class CaloriesDestinations(val route: String, @StringRes val title: Int) {
    object Statistics: CaloriesDestinations("statistics", R.string.statistics_screen_title)
    object Meals: CaloriesDestinations("meals", R.string.meals_screen_title)
    object Dishes: CaloriesDestinations("dishes", R.string.dishes_screen_title)
    object Catalog: CaloriesDestinations("catalog", R.string.catalog_screen_title)
}

@Composable
fun CaloriesNavHost(
    dishesViewModel: DishesViewModel,
    dishesDialogViewModel: DishesFullscreenDialogViewModel,
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = CaloriesDestinations.Statistics.route
        ) {

        }

        composable(
            route = CaloriesDestinations.Meals.route
        ) {

        }

        composable(
            route = CaloriesDestinations.Dishes.route
        ) {
            DishesScreen(
                viewModel = dishesViewModel,
                dishesDialogViewModel = dishesDialogViewModel,
                onDishClick = { dish ->
                    dishesViewModel.selectDish(dish)
                    dishesViewModel.changeDialogShowState()
                },
                onSaveClick = {
                    dishesDialogViewModel.saveDishToLocalStorage()
                    dishesViewModel.changeDialogShowState()
                }
            )
        }

        composable(
            route = CaloriesDestinations.Catalog.route
        ) {

        }
    }
}