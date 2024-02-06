package com.slyene.calories.ui.dishes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.data.Dish

@Composable
fun DishesFullscreenDialog(
    onSaveClick: (Dish) -> Unit,
    onDismissClick: () -> Unit,
    selectedDish: Int,
    modifier: Modifier = Modifier
    ) {
    Dialog(
        onDismissRequest = onDismissClick,
        //properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: DishesFullscreenDialogViewModel = viewModel()
        val uiState by viewModel.uiState

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LaunchedEffect(key1 = uiState.carbs) {
                viewModel.getDish(selectedDish)
            }
            Text(text = uiState.carbs)
        }
    }
}