package com.slyene.calories.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert
    suspend fun insert(item: Meal)

    @Update
    suspend fun update(item: Meal)

    @Delete
    suspend fun delete(item: Meal)

    @Query("SELECT * FROM meals")
    fun getMeals(): Flow<List<Meal>>

    @Query("SELECT * FROM meals WHERE id = :id")
    fun getMealById(id: Int): Flow<Meal>
}