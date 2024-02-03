package com.slyene.calories.ui.dishes

import androidx.lifecycle.ViewModel
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import com.slyene.calories.data.source.network.NetworkCaloriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val localCaloriesRepository: LocalCaloriesRepository,
    private val networkCaloriesRepository: NetworkCaloriesRepository
) : ViewModel() {
}