package com.slyene.calories.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes")
data class Dish(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    @ColumnInfo(name = "img_src")
    val imgSrc: String = "",
    val proteins: Int = 0,
    val fats: Int = 0,
    val carbohydrates: Int = 0
)
