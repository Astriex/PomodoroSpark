package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.feature_rewards.domain.models.Reward
import com.astriex.pomodorospark.feature_rewards.presenter.composables.RewardItem
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme
import kotlinx.coroutines.launch

@Composable
fun RewardsScreen(viewModel: RewardsViewModel = hiltViewModel()) {
    val dummyRewards = viewModel.dummyRewards.collectAsState(emptyList())
    ScreenContent(dummyRewards.value)
}

@Composable
private fun ScreenContent(dummyRewards: List<Reward>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.rewards)) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        }
    ) {
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

            if(listState.firstVisibleItemIndex > 5) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch { listState.animateScrollToItem(index = 0) }
                    },
                    backgroundColor = Color.LightGray,
                    contentColor = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(26.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ExpandLess,
                        contentDescription = stringResource(R.string.scroll_to_top),
                    )
                }
            }

        }
    }
}

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent(
                listOf(
                    Reward(Icons.Default.Star, "Reward 1", 1),
                    Reward(Icons.Default.LocalCarWash, "Reward 2", 5),
                    Reward(Icons.Default.LocalFireDepartment, "Reward 3", 50)
                )
            )
        }
    }
}
