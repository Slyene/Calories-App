package com.slyene.calories.ui.dishes

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
    val uiState: StateFlow<DishesUiState> = localCaloriesRepository.getAllDishes().map {
        DishesUiState(dishesList = it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = DishesUiState()
    )

    fun addDish() {
        viewModelScope.launch {
            localCaloriesRepository.upsertDish(
                Dish(
                    name = "Dish",
                    description = "Description",
                    proteins = "124",
                    fats = "214",
                    carbs = "235"
                )
            )
        }
    }
}