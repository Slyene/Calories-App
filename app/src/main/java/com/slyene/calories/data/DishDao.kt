package com.slyene.calories.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDao {
    @Insert
    suspend fun insert(item: Dish)

    @Update
    suspend fun update(item: Dish)

    @Delete
    suspend fun delete(item: Dish)

    @Query("SELECT * FROM meals")
    fun getDishes(): Flow<List<Dish>>

    @Query("SELECT * FROM meals WHERE id = :id")
    fun getDishById(id: Int): Flow<Dish>
}