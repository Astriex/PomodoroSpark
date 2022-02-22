package com.astriex.pomodorospark.feature_rewards.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward

@Entity(tableName = "table_rewards")
data class RewardEntity(
    val iconKey: String,
    val title: String,
    val chanceInPercent: Int,
    val isUnlocked: Boolean = false,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {

    fun toReward(): Reward = Reward(
        iconKey = iconKey,
        title = title,
        chanceInPercent = chanceInPercent,
        isUnlocked = isUnlocked
    )
}
