package com.astriex.pomodorospark.feature_rewards.presenter.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.astriex.pomodorospark.feature_rewards.domain.models.Reward

@Composable
fun RewardsList(dummyRewards: List<Reward>) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(state = listState, contentPadding = PaddingValues(bottom = 16.dp)) {
            items(dummyRewards) { reward ->
                RewardItem(reward = reward)
            }
        }

        if (listState.firstVisibleItemIndex > 3) {
            ScrollToTopFab(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(26.dp),
                coroutineScope = coroutineScope,
                listState = listState
            )
        }

    }
}
