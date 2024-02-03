package com.slyene.calories.ui.dishes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.slyene.calories.R
import com.slyene.calories.data.Dish
import com.slyene.calories.ui.theme.CaloriesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishItem(
    item: Dish,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    Card(
        onClick = { onClick(item.id) },
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.imgSrc,
                contentDescription = stringResource(id = R.string.dish_image),
                modifier = Modifier
                    .padding(12.dp)
                    .clip(RoundedCornerShape(10.dp)),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .padding(end = 12.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = R.string.proteins), fontWeight = FontWeight.Bold, fontSize = 10.sp)
                        Text(text = item.proteins)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = R.string.fats), fontWeight = FontWeight.Bold, fontSize = 10.sp)
                        Text(text = item.fats)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = R.string.carbs), fontWeight = FontWeight.Bold, fontSize = 10.sp)
                        Text(text = item.carbohydrates)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, locale = "ru")
@Composable
fun DishItemPreview() {
    CaloriesTheme {
        DishItem(
            item = Dish(
                name = "dish",
                description = "description",
                proteins = "100",
                fats = "100",
                carbohydrates = "100"
            ),
            onClick = {}
        )
    }
}