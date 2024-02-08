package com.slyene.calories.ui.dishes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.data.Dish
import com.slyene.calories.ui.SaveDishFab
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DishesFullscreenDialog(
    onSaveClick: (Dish) -> Unit,
    onDismissClick: () -> Unit,
    selectedDish: Int,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismissClick,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: DishesFullscreenDialogViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            floatingActionButton = {
                SaveDishFab(onClick = { onSaveClick(uiState.item) })
            },
            modifier = Modifier.fillMaxSize()
        ) {
            coroutineScope.launch {
                viewModel.getDish(selectedDish)
            }
            Surface(
                modifier = modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(
                        value = uiState.item.carbs,
                        onValueChange = {
                            viewModel.updateState(uiState.item.copy(carbs = it))
                        },
                        label = { Text(text = "label") })
                }

            }
        }
    }
}