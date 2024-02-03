package com.slyene.calories.data.source.local

import com.slyene.calories.data.CaloriesRepository
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalCaloriesRepository @Inject constructor(
    private val dishDao: DishDao,
    private val mealDao: MealDao
) : CaloriesRepository {
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