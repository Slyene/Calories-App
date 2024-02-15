package com.slyene.calories.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavOptions

@Composable
fun CaloriesNavigationBar(
    onClick: (String) -> Unit,
    currentScreen: String,
    modifier: Modifier = Modifier
) {
    var selectedNavBarItem by remember { mutableStateOf("") }

    NavigationBar(
        modifier = modifier, windowInsets = WindowInsets.navigationBars
    ) {
        NavigationBarItem(
            selected = currentScreen == CaloriesDestinations.StatisticsScreen.route,
            onClick = { onClick(CaloriesDestinations.StatisticsScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.StatisticsScreen.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onClick(CaloriesDestinations.MealsScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.MealsScreen.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onClick(CaloriesDestinations.DishesScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.DishesScreen.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onClick(CaloriesDestinations.CatalogScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.CatalogScreen.title))
            }
        )
    }
}