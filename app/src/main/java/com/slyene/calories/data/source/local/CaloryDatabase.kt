package com.slyene.calories.data.source.local

import androidx.room.Database
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal

@Database(entities = [Dish::class, Meal::class], version = 1, exportSchema = false)
abstract class CaloryDatabase {
    abstract fun getDishDao(): DishDao
    abstract fun getMealDao(): MealDao
}