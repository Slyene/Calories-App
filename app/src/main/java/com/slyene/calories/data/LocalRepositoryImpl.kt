package com.slyene.calories.data

import com.slyene.calories.data.source.local.DishDao
import com.slyene.calories.data.source.local.LocalRepository
import com.slyene.calories.data.source.local.MealDao
import kotlinx.coroutines.flow.Flow

class LocalRepositoryImpl(
    private val dishDao: DishDao,
    private val mealDao: MealDao
) : LocalRepository {
    override suspend fun upsertDish(item: Dish) {
        dishDao.upsert(item)
    }

    override suspend fun deleteDish(item: Dish) {
        dishDao.delete(item)
    }

    override fun getAllDishes(): Flow<List<Dish>> {
        return dishDao.getAll()
    }

    override fun getDishById(id: Int): Flow<Dish> {
        return dishDao.getById(id)
    }

    override suspend fun upsertMeal(item: Meal) {
        mealDao.upsert(item)
    }

    override suspend fun deleteMeal(item: Meal) {
        mealDao.delete(item)
    }

    override fun getAllMeals(): Flow<List<Meal>> {
        return mealDao.getAll()
    }

    override fun getMealById(id: Int): Flow<Meal> {
        return mealDao.getById(id)
    }
}