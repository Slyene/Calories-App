package com.slyene.calories.data

import android.net.Uri
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
    val imgSrc: Uri? = null,
    val proteins: String = "",
    val fats: String = "",
    val carbs: String = ""
)
