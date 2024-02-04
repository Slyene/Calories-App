package com.slyene.calories.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.slyene.calories.data.CaloriesRepository
import com.slyene.calories.data.source.local.CaloriesDatabase
import com.slyene.calories.data.source.local.DishDao
import com.slyene.calories.data.source.local.LocalCaloriesRepository
import com.slyene.calories.data.source.local.MealDao
import com.slyene.calories.data.source.network.NetworkCaloriesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocalCaloriesRepository(repository: LocalCaloriesRepository): CaloriesRepository

    @Singleton
    @Binds
    abstract fun bindNetworkCaloriesRepository(repository: NetworkCaloriesRepository): CaloriesRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CaloriesDatabase {
        return Room.databaseBuilder(
            context = context.applicationContext,
            klass = CaloriesDatabase::class.java,
            name = "CaloriesDatabase.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDishDao(database: CaloriesDatabase): DishDao = database.getDishDao()

    @Provides
    fun provideMealDao(database: CaloriesDatabase): MealDao = database.getMealDao()
}