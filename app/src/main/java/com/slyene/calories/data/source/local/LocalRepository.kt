package com.slyene.calories.data.source.local

import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun upsertDish(item: Dish)

    suspend fun deleteDish(item: Dish)

    fun getAllDishes(): Flow<List<Dish>>

    fun getDishById(id: Int): Flow<Dish>

    suspend fun upsertMeal(item: Meal)

    suspend fun deleteMeal(item: Meal)

    fun getAllMeals(): Flow<List<Meal>>

    fun getMealById(id: Int): Flow<Meal>
}