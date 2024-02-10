package com.slyene.calories.ui.dishes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.slyene.calories.R
import com.slyene.calories.ui.CaloriesPhotoPicker
import com.slyene.calories.ui.CaloriesFab

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DishesFullscreenDialog(
    onSaveClick: () -> Unit,
    onDismissClick: () -> Unit,
    selectedDish: Int,
    modifier: Modifier = Modifier,
    viewModel: DishesFullscreenDialogViewModel = viewModel()
) {
    Dialog(
        onDismissRequest = onDismissClick,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val uiState by viewModel.uiState.collectAsState()

        LaunchedEffect(key1 = uiState.item.id) {
            viewModel.getDish(selectedDish)
        }

        Scaffold(
            floatingActionButton = {
                CaloriesFab(icon = Icons.Default.Check, onClick = onSaveClick)
            },
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = modifier
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CaloriesPhotoPicker(
                    onImageSelect = { uri ->
                        if (uri != null)
                            viewModel.updateState(uiState.item.copy(imgSrc = uri))
                    },
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(40.dp))
                        .background(MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Box(modifier = it) {
                        if (uiState.item.imgSrc != null) {
                            AsyncImage(
                                model = uiState.item.imgSrc,
                                contentDescription = stringResource(id = R.string.dish_image),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Image(
                                imageVector = Icons.Rounded.AddCircle,
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.outline),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(40.dp)
                            )
                        }
                    }
                }
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