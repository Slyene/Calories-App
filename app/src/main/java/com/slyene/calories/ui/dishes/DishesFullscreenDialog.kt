package com.slyene.calories.ui.dishes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.slyene.calories.data.Dish

@Composable
fun DishesFullscreenDialog(
    onSaveClick: (Dish) -> Unit,
    onDismissClick: () -> Unit,
    item: Dish?,
    modifier: Modifier = Modifier
    ) {
    Dialog(
        onDismissRequest = onDismissClick,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {

    }
}