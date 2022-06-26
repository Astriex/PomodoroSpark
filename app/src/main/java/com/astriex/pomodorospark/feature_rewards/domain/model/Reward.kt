package com.astriex.pomodorospark.feature_rewards.domain.model

import com.astriex.pomodorospark.feature_rewards.data.local.entity.RewardEntity


data class Reward(
    val iconKey: String,
    val title: String,
    val chanceInPercent: Int,
    val isUnlocked: Boolean
) {
    fun toRewardEntity(): RewardEntity = RewardEntity(
        iconKey = iconKey,
        title = title,
        chanceInPercent = chanceInPercent,
        isUnlocked = isUnlocked
    )
}


