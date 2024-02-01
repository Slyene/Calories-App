package com.slyene.calories.di

import android.content.Context
import androidx.room.Room
import com.slyene.calories.data.CaloryRepository
import com.slyene.calories.data.source.local.CaloryDatabase
import com.slyene.calories.data.source.local.DishDao
import com.slyene.calories.data.source.local.LocalCaloryRepository
import com.slyene.calories.data.source.local.MealDao
import com.slyene.calories.data.source.network.NetworkCaloryRepository
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
    abstract fun bindLocalCaloryRepository(repository: LocalCaloryRepository): CaloryRepository

    @Singleton
    @Binds
    abstract fun bindNetworkCaloryRepository(repository: NetworkCaloryRepository): CaloryRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CaloryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CaloryDatabase::class.java,
            "CaloryDatabase.db"
        ).build()
    }

    @Provides
    fun provideDishDao(database: CaloryDatabase): DishDao = database.getDishDao()

    @Provides
    fun provideMealDao(database: CaloryDatabase): MealDao = database.getMealDao()
}