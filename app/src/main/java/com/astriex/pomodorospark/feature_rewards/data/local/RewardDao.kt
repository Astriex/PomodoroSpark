package com.astriex.pomodorospark.feature_rewards.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.astriex.pomodorospark.feature_rewards.data.local.entity.RewardEntity
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import kotlinx.coroutines.flow.Flow

@Dao
interface RewardDao {

    @Query("SELECT * FROM table_rewards")
    fun getAllRewards(): Flow<List<Reward>>

    @Insert(onConflict = REPLACE)
    suspend fun insertReward(reward: RewardEntity)

}