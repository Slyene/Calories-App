package com.slyene.calories.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.slyene.calories.R
import com.slyene.calories.ui.dishes.DishesFullscreenDialogViewModel
import com.slyene.calories.ui.dishes.DishesScreen
import com.slyene.calories.ui.dishes.DishesViewModel

sealed class CaloriesDestinations(val route: String, @StringRes val title: Int) {
    data object StatisticsScreen: CaloriesDestinations("statistics_screen", R.string.statistics_screen_title) {
        data object Statistics: CaloriesDestinations("statistics", R.string.statistics_screen_title)
    }
    data object MealsScreen: CaloriesDestinations("meals_screen", R.string.meals_screen_title) {
        data object Meals: CaloriesDestinations("meals", R.string.meals_screen_title)
    }
    data object DishesScreen: CaloriesDestinations("dishes_screen", R.string.dishes_screen_title) {
        data object Dishes: CaloriesDestinations("dishes", R.string.dishes_screen_title)
    }
    data object CatalogScreen: CaloriesDestinations("catalog_screen", R.string.catalog_screen_title) {
        data object Catalog: CaloriesDestinations("catalog", R.string.catalog_screen_title)
    }
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
        navigation(
            startDestination = CaloriesDestinations.StatisticsScreen.Statistics.route,
            route = CaloriesDestinations.StatisticsScreen.route
        ) {
            composable(
                route = CaloriesDestinations.StatisticsScreen.Statistics.route
            ) {

            }
        }

        navigation(
            startDestination = CaloriesDestinations.MealsScreen.Meals.route,
            route = CaloriesDestinations.MealsScreen.route
        ) {
            composable(
                route = CaloriesDestinations.MealsScreen.Meals.route
            ) {

            }
        }

        navigation(
            startDestination = CaloriesDestinations.DishesScreen.Dishes.route,
            route = CaloriesDestinations.DishesScreen.route
        ) {
            composable(
                route = CaloriesDestinations.DishesScreen.Dishes.route
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
        }

        navigation(
            startDestination = CaloriesDestinations.CatalogScreen.Catalog.route,
            route = CaloriesDestinations.CatalogScreen.route
        ) {
            composable(
                route = CaloriesDestinations.CatalogScreen.Catalog.route
            ) {

            }
        }

//        composable(
//            route = CaloriesDestinations.Meals.route
//        ) {
//
//        }
//
//        composable(
//            route = CaloriesDestinations.Dishes.route
//        ) {
//            DishesScreen(
//                viewModel = dishesViewModel,
//                dishesDialogViewModel = dishesDialogViewModel,
//                onDishClick = { dish ->
//                    dishesViewModel.selectDish(dish)
//                    dishesViewModel.changeDialogShowState()
//                },
//                onSaveClick = {
//                    dishesDialogViewModel.saveDishToLocalStorage()
//                    dishesViewModel.changeDialogShowState()
//                }
//            )
//        }
//
//        composable(
//            route = CaloriesDestinations.Catalog.route
//        ) {
//
//        }
    }
}