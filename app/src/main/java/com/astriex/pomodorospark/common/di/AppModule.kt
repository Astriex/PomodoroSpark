package com.astriex.pomodorospark.common.di

import android.content.Context
import androidx.room.Room
import com.astriex.pomodorospark.common.data.local.PSDatabase
import com.astriex.pomodorospark.feature_rewards.data.local.RewardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRewardDao(db: PSDatabase): RewardDao = db.rewardDao()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context,
        callback: PSDatabase.PSDBCallback
    ): PSDatabase =
        Room.databaseBuilder(app, PSDatabase::class.java, "pomodoroSparkDB").addCallback(callback)
            .build()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope