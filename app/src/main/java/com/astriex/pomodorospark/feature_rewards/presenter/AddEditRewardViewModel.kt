package com.astriex.pomodorospark.feature_rewards.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditRewardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _rewardNameInput = savedStateHandle.getLiveData<String>("rewardNameLiveData", "")
    val rewardNameInput: LiveData<String> = _rewardNameInput

    // when the id is passed around with navigation it will be automatically saved
    val rewardId = savedStateHandle.get<Long>(ARG_REWARD_ID)
    val isEditMode = (rewardId != null)

    private val _chanceInPercentInput = savedStateHandle.getLiveData<Int>("chanceInPercentLiveData", 10)
    val chanceInPercentInput: LiveData<Int> = _chanceInPercentInput

    fun onRewardNameInputChange(input: String) {
        _rewardNameInput.value = input
    }

    fun onChanceInPercentInputChange(input: Int) {
        _chanceInPercentInput.value = input
    }

}

const val ARG_REWARD_ID = "ARG_REWARD_ID"