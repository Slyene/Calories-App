package com.slyene.calories.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "meals")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val dishes: List<Dish> = listOf(),
    @ColumnInfo(name = "date_time")
    val dateTime: Date = Date()
)
