package com.slyene.calories.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal
import com.slyene.calories.data.source.CaloriesTypeConverters

@Database(entities = [Dish::class, Meal::class, DishesInMeal::class], version = 3, exportSchema = false)
@TypeConverters(CaloriesTypeConverters::class)
abstract class CaloriesDatabase : RoomDatabase() {
    abstract fun getDishDao(): DishDao
    abstract fun getMealDao(): MealDao
}