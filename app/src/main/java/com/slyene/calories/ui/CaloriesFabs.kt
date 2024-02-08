package com.slyene.calories.ui

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import com.slyene.calories.R

@Composable
fun AddDishFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Image(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_dish_fab),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
        )
    }
}
@Composable
fun SaveDishFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Image(
            imageVector = Icons.Default.Check,
            contentDescription = stringResource(id = R.string.add_dish_fab),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
        )
    }
}