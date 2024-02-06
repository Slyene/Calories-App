package com.slyene.calories.data

import kotlinx.coroutines.flow.Flow

interface CaloriesRepository {
    suspend fun upsertDish(item: Dish)

    suspend fun deleteDish(item: Dish)

    fun getAllDishes(): Flow<List<Dish>>

    suspend fun getDishById(id: Int): Dish

    suspend fun upsertMeal(item: Meal)

    suspend fun deleteMeal(item: Meal)

    fun getAllMeals(): Flow<List<Meal>>

    fun getMealById(id: Int): Flow<Meal>
}