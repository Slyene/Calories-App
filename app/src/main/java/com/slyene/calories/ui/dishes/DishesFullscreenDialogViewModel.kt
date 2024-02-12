package com.slyene.calories.ui.dishes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyene.calories.data.Dish
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesFullscreenDialogViewModel @Inject constructor(
    private val localCaloriesRepository: LocalCaloriesRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<DishesFullscreenDialogUiState> =
        MutableStateFlow(DishesFullscreenDialogUiState())
    val uiState: StateFlow<DishesFullscreenDialogUiState> = _uiState.asStateFlow()

    fun getDish(item: Dish?) {
        _uiState.update {
            DishesFullscreenDialogUiState(item = item ?: Dish())
        }
    }

    fun updateState(item: Dish) {
        _uiState.update {
            it.copy(item = item)
        }
    }

    fun validateInput() {
        with(uiState.value.item) {
            _uiState.update {
                if (name.isEmpty() || name.isBlank()) {
                    it.copy(isInvalidInput = true)
                } else {
                    it.copy(isInvalidInput = false)
                }
            }
        }
    }

    fun saveDishToLocalStorage() {
        viewModelScope.launch {
            localCaloriesRepository.upsertDish(uiState.value.item)
        }
    }
}