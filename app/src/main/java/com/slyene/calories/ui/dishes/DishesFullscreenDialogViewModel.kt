package com.slyene.calories.ui.dishes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyene.calories.data.Dish
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesFullscreenDialogViewModel @Inject constructor(
    private val localCaloriesRepository: LocalCaloriesRepository,
) : ViewModel() {
    private val _uiState: MutableState<DishesFullscreenDialogUiState> = mutableStateOf(
        DishesFullscreenDialogUiState()
    )
    val uiState: State<DishesFullscreenDialogUiState> = _uiState

    fun getDish(id: Int) {
        var dish: Dish? = null
        viewModelScope.launch {
            dish = localCaloriesRepository.getDishById(id)

            updateState(
                DishesFullscreenDialogUiState(
                    imgSrc = dish?.imgSrc ?: "",
                    description = dish?.description ?: "",
                    proteins = dish?.proteins ?: "",
                    fats = dish?.fats ?: "",
                    carbs = dish?.fats ?: ""
                )
            )
        }
    }

    fun updateState(state: DishesFullscreenDialogUiState) {
        _uiState.value = state
    }
}