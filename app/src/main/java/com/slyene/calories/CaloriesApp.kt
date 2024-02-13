package com.slyene.calories

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
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

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = (backStackEntry?.destination?.route ?: CaloriesDestinations.StatisticsScreen.route)


    Scaffold(
        topBar = {
            CaloriesTopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                onBackPressed = { navController.navigateUp() }
            )
        },
        bottomBar = {
            CaloriesNavigationBar(navController = navController)
        },
        floatingActionButton = {
            if (currentScreen == CaloriesDestinations.DishesScreen.route) {
                CaloriesFab(icon = ImageVector.vectorResource(id = R.drawable.rounded_add_24)) {
                    dishesViewModel.selectDish(null)
                    dishesViewModel.changeDialogShowState()
                }
            }
        }
    ) {
        CaloriesNavHost(
            dishesViewModel = dishesViewModel,
            dishesDialogViewModel = dishesDialogViewModel,
            navController = navController,
            startDestination = CaloriesDestinations.StatisticsScreen.route,
            modifier = Modifier.padding(it)
        )
    }
}