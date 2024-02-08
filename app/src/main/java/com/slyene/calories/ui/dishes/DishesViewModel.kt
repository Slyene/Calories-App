package com.slyene.calories.ui.dishes


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    localCaloriesRepository: LocalCaloriesRepository
) : ViewModel() {
    private val _dishesUiState: MutableStateFlow<DishesUiState> = MutableStateFlow(DishesUiState())
    val dishesUiState: StateFlow<DishesUiState> = _dishesUiState.asStateFlow()

    val dishesListUiState: StateFlow<DishesListUiState> = localCaloriesRepository.getAllDishes().map {
        DishesListUiState(dishesList = it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = DishesListUiState()
    )

    fun selectDish(id: Int = 0) {
        _dishesUiState.update {
            it.copy(selectedDish = id)
        }
    }

    fun changeDialogShowState() {
        _dishesUiState.update {
            it.copy(showDialog = !it.showDialog)
        }
    }
}