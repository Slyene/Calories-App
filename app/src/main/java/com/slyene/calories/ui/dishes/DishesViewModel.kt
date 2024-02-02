package com.slyene.calories.ui.dishes

import androidx.lifecycle.ViewModel
import com.slyene.calories.data.source.local.LocalCaloryRepository
import com.slyene.calories.data.source.network.NetworkCaloryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val localCaloryRepository: LocalCaloryRepository,
    private val networkCaloryRepository: NetworkCaloryRepository
) : ViewModel() {
}