package com.slyene.calories.ui.dishes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.ui.theme.CaloriesTheme

@Composable
fun DishesScreen(
    dishesDialogViewModel: DishesFullscreenDialogViewModel,
    onDishClick: (Int) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DishesViewModel = viewModel(),
) {
    val dishesUiState by viewModel.dishesUiState.collectAsState()
    val dishesListUiState by viewModel.dishesListUiState.collectAsState()

    if (dishesUiState.showDialog) {
        DishesFullscreenDialog(
            onSaveClick = onSaveClick,
            onDismissClick = viewModel::changeDialogShowState,
            selectedDish = dishesUiState.selectedDish,
            viewModel = dishesDialogViewModel,
            modifier = Modifier.padding(15.dp)
        )
    }
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(dishesListUiState.dishesList) { dish ->
            DishItem(
                item = dish,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                onClick = onDishClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DishesScreenPreview() {
    CaloriesTheme {
        Surface {
            DishesScreen(
                dishesDialogViewModel = viewModel(),
                onDishClick = {},
                onSaveClick = {}
            )
        }
    }
}
