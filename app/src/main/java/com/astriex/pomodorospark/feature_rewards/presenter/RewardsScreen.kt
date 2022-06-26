package com.astriex.pomodorospark.feature_rewards.presenter

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.common.presenter.composables.DefaultTopAppBar
import com.astriex.pomodorospark.common.presenter.util.FullScreenDestinations
import com.astriex.pomodorospark.feature_rewards.data.local.util.IconKeys
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import com.astriex.pomodorospark.feature_rewards.presenter.composables.RewardsList
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun RewardsScreen(navController: NavController, viewModel: RewardsViewModel = hiltViewModel()) {
    val rewards = viewModel.rewards.collectAsState(initial = emptyList())
    ScreenContent(
        navController = navController,
        onAddRewardClicked = {
            navController.navigate(FullScreenDestinations.AddEditRewardScreen.route)
        },
        dummyRewards = rewards.value
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ScreenContent(
    navController: NavController,
    onAddRewardClicked: () -> Unit,
    dummyRewards: List<Reward>
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar(title = "Rewards")
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddRewardClicked,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        }
    ) {
        RewardsList(navController, dummyRewards)
    }
}

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent(
                navController = rememberNavController(),
                onAddRewardClicked = {},
                dummyRewards = listOf(
                    Reward(
                        iconKey = IconKeys.CAKE,
                        title = "CAKE",
                        chanceInPercent = 1,
                        isUnlocked = false
                    ),
                    Reward(
                        iconKey = IconKeys.BATHTUB,
                        title = "BATHTUB",
                        chanceInPercent = 5,
                        isUnlocked = false
                    ),
                    Reward(
                        iconKey = IconKeys.MOVIE,
                        title = "MOVIE",
                        chanceInPercent = 50,
                        isUnlocked = false
                    )
                )
            )
        }
    }
}
