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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun CaloriesNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier, windowInsets = WindowInsets.navigationBars
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(CaloriesDestinations.Statistics.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.Statistics.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(CaloriesDestinations.Meals.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.Meals.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(CaloriesDestinations.Dishes.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.Dishes.title))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(CaloriesDestinations.Catalog.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = CaloriesDestinations.Catalog.title))
            }
        )
    }
}