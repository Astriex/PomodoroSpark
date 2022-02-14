package com.astriex.pomodorospark.feature_rewards.presenter

import androidx.lifecycle.ViewModel
import com.astriex.pomodorospark.feature_rewards.data.local.RewardDao
import com.astriex.pomodorospark.feature_rewards.data.local.util.IconKeys
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(
    private val rewardDao: RewardDao
) : ViewModel() {

    val rewards = rewardDao.getAllRewards()

}