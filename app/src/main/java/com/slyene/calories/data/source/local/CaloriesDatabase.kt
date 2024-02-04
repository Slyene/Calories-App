package com.slyene.calories.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal

@Database(entities = [Dish::class, Meal::class, DishesInMeal::class], version = 2, exportSchema = false)
abstract class CaloriesDatabase : RoomDatabase() {
    abstract fun getDishDao(): DishDao
    abstract fun getMealDao(): MealDao
}