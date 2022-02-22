package com.astriex.pomodorospark.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.astriex.pomodorospark.common.di.ApplicationScope
import com.astriex.pomodorospark.feature_rewards.data.local.RewardDao
import com.astriex.pomodorospark.feature_rewards.data.local.entity.RewardEntity
import com.astriex.pomodorospark.feature_rewards.data.local.util.IconKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [RewardEntity::class], version = 1)
abstract class PSDatabase : RoomDatabase() {
    abstract fun rewardDao(): RewardDao

    // To resolve circular dependency Provider makes the database instantiation lazy
    class PSDBCallback @Inject constructor(
        private val database: Provider<PSDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            // get needed because of Provider
            val rewardDao = database.get().rewardDao()

            applicationScope.launch {
                rewardDao.insertReward(
                    RewardEntity(
                        iconKey = IconKeys.CAKE,
                        title = "1 piece of cake",
                        chanceInPercent = 5
                    )
                )
                rewardDao.insertReward(
                    RewardEntity(
                        iconKey = IconKeys.BATHTUB,
                        title = "Taking a bath",
                        chanceInPercent = 7
                    )
                )
                rewardDao.insertReward(
                    RewardEntity(
                        iconKey = IconKeys.MOVIE,
                        title = "Watch an episode of Supernatural",
                        chanceInPercent = 10
                    )
                )
            }

        }
    }
}