package com.slyene.calories.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.slyene.calories.data.Dish
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDao {
    @Upsert
    suspend fun upsert(item: Dish)

    @Delete
    suspend fun delete(item: Dish)

    @Query("SELECT * FROM dishes")
    fun getAll(): Flow<List<Dish>>

    @Query("SELECT * FROM dishes WHERE id = :id")
     suspend fun getById(id: Int): Dish
}