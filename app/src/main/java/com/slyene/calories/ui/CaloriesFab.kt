package com.slyene.calories.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.slyene.calories.R

@Composable
fun CaloriesFab(
    icon: ImageVector,
    onClick: () -> Unit
) {
    FloatingActionButton(onClick = onClick) {
        Image(
            imageVector = icon,
            contentDescription = stringResource(id = R.string.add_dish_fab),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
        )
    }
}