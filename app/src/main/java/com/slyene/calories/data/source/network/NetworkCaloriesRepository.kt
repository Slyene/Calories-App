package com.slyene.calories.data.source.network

import com.slyene.calories.data.CaloriesRepository
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal
import kotlinx.coroutines.flow.Flow

class NetworkCaloriesRepository() : CaloriesRepository {
    override suspend fun upsertDish(item: Dish) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDish(item: Dish) {
        TODO("Not yet implemented")
    }

    override fun getAllDishes(): Flow<List<Dish>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDishById(id: Int): Dish {
        TODO("Not yet implemented")
    }

    override suspend fun upsertMeal(item: Meal) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMeal(item: Meal) {
        TODO("Not yet implemented")
    }

    override fun getAllMeals(): Flow<List<Meal>> {
        TODO("Not yet implemented")
    }

    override fun getMealById(id: Int): Flow<Meal> {
        TODO("Not yet implemented")
    }
}