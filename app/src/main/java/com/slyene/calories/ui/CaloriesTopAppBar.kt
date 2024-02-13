package com.slyene.calories.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.slyene.calories.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloriesTopAppBar(
    canNavigateBack: Boolean,
    currentScreen: String,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = { Text(text = currentScreen.replaceFirstChar { it.uppercase() }) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onBackPressed) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.rounded_arrow_back_24),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                    )
                }
            }
        }
    )
}