package com.slyene.calories.ui.dishes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slyene.calories.R
import com.slyene.calories.data.Dish
import com.slyene.calories.ui.theme.CaloriesTheme

@Composable
fun DishesScreen(
    modifier: Modifier = Modifier,
    viewModel: DishesViewModel = viewModel(),
    onFabClick: () -> Unit,
    onDishClick: (Int) -> Unit,
    onSaveClick: (Dish) -> Unit
) {
    val dishesUiState by viewModel.dishesUiState
    val dishesListUiState by viewModel.dishesListUiState.collectAsState()

    Scaffold(
        modifier = modifier,
        floatingActionButton = { FAB(onClick = onFabClick) }
    ) {
        if (dishesUiState.showDialog) {
            DishesFullscreenDialog(
                onSaveClick = onSaveClick,
                onDismissClick = viewModel::changeDialogShowState,
                selectedDish = dishesUiState.selectedDish
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = it.calculateTopPadding() + 8.dp,
                bottom = it.calculateBottomPadding()
            )
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

}

@Composable
fun FAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Image(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_dish_fab),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DishesScreenPreview() {
    CaloriesTheme {
        Surface {
            DishesScreen(
                onFabClick = {},
                onDishClick = {},
                onSaveClick = {}
            )
        }
    }
}
