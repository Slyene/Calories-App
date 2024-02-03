package com.slyene.calories.data.source.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.slyene.calories.data.Dish
import com.slyene.calories.data.Meal

@Entity(
    tableName = "dishes_in_meal",
    foreignKeys = [
        ForeignKey(entity = Meal::class, parentColumns = ["id"], childColumns = ["mealId"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        ForeignKey(entity = Dish::class, parentColumns = ["id"], childColumns = ["dishId"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    ],
)
data class DishesInMeal (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val mealId: Int = 0,
    val dishId: Int = 0
    )