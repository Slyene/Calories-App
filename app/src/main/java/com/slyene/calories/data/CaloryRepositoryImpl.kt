package com.slyene.calories.data

import kotlinx.coroutines.flow.Flow

class CaloryRepositoryImpl(

) : CaloryRepository {
    override suspend fun upsertDish(item: Dish) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDish(item: Dish) {
        TODO("Not yet implemented")
    }

    override fun getAllDishes(): Flow<List<Dish>> {
        TODO("Not yet implemented")
    }

    override fun getDishById(id: Int): Flow<Dish> {
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