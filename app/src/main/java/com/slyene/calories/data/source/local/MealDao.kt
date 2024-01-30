package com.slyene.calories.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.slyene.calories.data.Meal
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Upsert
    suspend fun upsert(item: Meal)

    @Delete
    suspend fun delete(item: Meal)

    @Query("SELECT * FROM meals")
    fun getAll(): Flow<List<Meal>>

    @Query("SELECT * FROM meals WHERE id = :id")
    fun getById(id: Int): Flow<Meal>
}