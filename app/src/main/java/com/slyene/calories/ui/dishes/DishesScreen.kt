package com.slyene.calories.ui.dishes

import android.annotation.SuppressLint
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
import com.slyene.calories.data.Dish
import com.slyene.calories.ui.theme.CaloriesTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DishesScreen(
    modifier: Modifier = Modifier,
    viewModel: DishesViewModel = viewModel(),
    onDishClick: (Int) -> Unit,
    onSaveClick: (Dish) -> Unit
) {
    val dishesUiState by viewModel.dishesUiState.collectAsState()
    val dishesListUiState by viewModel.dishesListUiState.collectAsState()

    if (dishesUiState.showDialog) {
        DishesFullscreenDialog(
            onSaveClick = onSaveClick,
            onDismissClick = viewModel::changeDialogShowState,
            selectedDish = dishesUiState.selectedDish
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
                onDishClick = {},
                onSaveClick = {}
            )
        }
    }
}
