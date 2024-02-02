package com.slyene.calories.ui.dishes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slyene.calories.data.Dish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishItem(
    item: Dish,
    modifier: Modifier = Modifier,
    onClicked: (Int) -> Unit
) {
    Card(
        onClick = { onClicked(item.id) },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Row {
            if (item.)
        }
    }
}

@Preview
@Composable
fun DishItemPreview() {
    DishItem(
        item = Dish(
            name = "dish",
            description = "description"
        ),
        onClicked = {}
    )
}