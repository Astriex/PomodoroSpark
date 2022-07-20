package com.astriex.pomodorospark.feature_rewards.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astriex.pomodorospark.feature_rewards.data.local.RewardDao
import com.astriex.pomodorospark.feature_rewards.data.local.util.IconKeys
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditRewardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val rewardDao: RewardDao
) : ViewModel() {

    sealed class AddEditRewardEvent {
        object RewardCreated : AddEditRewardEvent()
    }

    private val eventChannel = Channel<AddEditRewardEvent>()
    val events = eventChannel.receiveAsFlow()

    private val _rewardNameInput = savedStateHandle.getLiveData<String>("rewardNameLiveData", "")
    val rewardNameInput: LiveData<String> = _rewardNameInput

    // when the id is passed around with navigation it will be automatically saved
    val rewardId = savedStateHandle.get<Long>(ARG_REWARD_ID)
    val isEditMode = (rewardId != null)

    private val _chanceInPercentInput =
        savedStateHandle.getLiveData<Int>("chanceInPercentLiveData", 10)
    val chanceInPercentInput: LiveData<Int> = _chanceInPercentInput

    private val _showRewardIconButtonSelection =
        savedStateHandle.getLiveData<Boolean>("showRewardIconButtonSelection", false)
    val showRewardIconButtonSelection: LiveData<Boolean> = _showRewardIconButtonSelection

    fun onRewardNameInputChange(input: String) {
        _rewardNameInput.value = input
    }

    fun onChanceInPercentInputChange(input: Int) {
        _chanceInPercentInput.value = input
    }

    fun onRewardIconButtonClicked() {
        _showRewardIconButtonSelection.value = true
    }

    fun onSaveClicked() {
        val rewardNameInput = rewardNameInput.value
        val chanceInPercentInput = chanceInPercentInput.value

        viewModelScope.launch {
            if (rewardNameInput != null && rewardNameInput.isNotBlank()
                && chanceInPercentInput != null
            ) {
                if (rewardId != null) {
                    //updateReward()
                } else {
                    // TODO: set the icon on the add/edit screen
                    createReward(
                        Reward(
                            IconKeys.DEFAULT,
                            rewardNameInput,
                            chanceInPercentInput,
                            false
                        )
                    )
                }
            } else {
                //TODO: show error
            }
        }
    }

    private suspend fun updateReward(reward: Reward) {

    }

    private suspend fun createReward(reward: Reward) {
        rewardDao.insertReward(reward.toRewardEntity())
        eventChannel.send(AddEditRewardEvent.RewardCreated)
    }

}

const val ARG_REWARD_ID = "ARG_REWARD_ID"