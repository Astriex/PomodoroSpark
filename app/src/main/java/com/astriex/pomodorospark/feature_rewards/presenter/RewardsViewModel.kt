package com.astriex.pomodorospark.feature_rewards.presenter

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.lifecycle.ViewModel
import com.astriex.pomodorospark.feature_rewards.domain.models.Reward
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor() : ViewModel() {
    private var _dummyRewards = MutableStateFlow<List<Reward>>(emptyList())
    val dummyRewards: StateFlow<List<Reward>>
        get() = _dummyRewards

    init {
        val dummyRewards = mutableListOf<Reward>()
        repeat(50) { index ->
            dummyRewards += Reward(icon = Icons.Default.Star, "item $index", index)
        }
        _dummyRewards.value = dummyRewards
    }
}