package com.slyene.calories.ui.dishes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyene.calories.data.Dish
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val localCaloriesRepository: LocalCaloriesRepository
) : ViewModel() {
    private val _dishesUiState: MutableState<DishesUiState> = mutableStateOf(DishesUiState())
    val dishesUiState: State<DishesUiState> = _dishesUiState

    val dishesListUiState: StateFlow<DishesListUiState> = localCaloriesRepository.getAllDishes().map {
        DishesListUiState(dishesList = it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = DishesListUiState()
    )

    fun saveToLocalStorage(item: Dish) {
        viewModelScope.launch {
            localCaloriesRepository.upsertDish(item)
        }
    }

    fun selectDish(item: Dish) {
        _dishesUiState.value = _dishesUiState.value.copy(selectedDish = item)
    }

    fun changeDialogShowState() {
        _dishesUiState.value = _dishesUiState.value.copy(showDialog = !_dishesUiState.value.showDialog)
    }
}