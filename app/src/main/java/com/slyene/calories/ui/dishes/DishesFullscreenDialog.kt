package com.slyene.calories.ui.dishes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.slyene.calories.R
import com.slyene.calories.ui.CaloriesPhotoPicker
import com.slyene.calories.ui.CaloriesFab

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DishesFullscreenDialog(
    onSaveClick: () -> Unit,
    onDismissClick: () -> Unit,
    onBackPressed: () -> Unit,
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
            viewModel.validateInput()
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Add dish") },
                    navigationIcon = {
                        IconButton(onClick = onBackPressed) {
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.rounded_arrow_back_24),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                if (!uiState.isInvalidInput) {
                    CaloriesFab(
                        icon = ImageVector.vectorResource(id = R.drawable.rounded_check_24),
                        onClick = onSaveClick
                    )
                }
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
                                imageVector = ImageVector.vectorResource(id = R.drawable.rounded_add_photo_alternate_24),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.outline),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(80.dp)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(15.dp))

                ElevatedCard {
                    Column(modifier = Modifier.padding(15.dp)) {
                        OutlinedTextField(
                            value = uiState.item.name,
                            onValueChange = {
                                viewModel.updateState(uiState.item.copy(name = it))
                                viewModel.validateInput()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = stringResource(id = R.string.dish_name) + "*") },
                            isError = uiState.isInvalidInput,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = uiState.item.proteins,
                            onValueChange = {
                                viewModel.updateState(uiState.item.copy(proteins = it))
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = stringResource(id = R.string.proteins)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = uiState.item.fats,
                            onValueChange = {
                                viewModel.updateState(uiState.item.copy(fats = it))
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = stringResource(id = R.string.fats)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = uiState.item.carbs,
                            onValueChange = {
                                viewModel.updateState(uiState.item.copy(carbs = it))
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = stringResource(id = R.string.carbs)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = uiState.item.description,
                            onValueChange = {
                                viewModel.updateState(uiState.item.copy(description = it))
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = stringResource(id = R.string.dish_description)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                }
            }
        }
    }
}