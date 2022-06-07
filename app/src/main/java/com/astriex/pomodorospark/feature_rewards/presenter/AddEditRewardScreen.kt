package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.common.presenter.composables.CustomTopAppBar
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun AddEditRewardScreen(viewModel: AddEditRewardViewModel = hiltViewModel()) {
    val rewardNameInput by viewModel.rewardNameInput.observeAsState("")
    val chanceInPercentInput by viewModel.chanceInPercentInput.observeAsState(10)
    val isEdit: Boolean = viewModel.isEditMode

    ScreenContent(
        isEditMode = isEdit,
        rewardNameInput = rewardNameInput,
        chanceInPercentInput = chanceInPercentInput,
        onRewardNameInputChange = viewModel::onRewardNameInputChange,
        onChanceInputChange = viewModel::onChanceInPercentInputChange
    )
}

@Composable
fun ScreenContent(
    isEditMode: Boolean,
    rewardNameInput: String,
    chanceInPercentInput: Int,
    onRewardNameInputChange: (input: String) -> Unit,
    onChanceInputChange: (input: Int) -> Unit
) {
    Scaffold(
        topBar = {
            val appBarTitle =
                stringResource(id = (if (isEditMode) R.string.edit_reward else R.string.add_reward))
            CustomTopAppBar(title = appBarTitle)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = stringResource(R.string.save_reward)
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TextField(
                value = rewardNameInput,
                onValueChange = onRewardNameInputChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.reward_name))
                },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.chance))
            Spacer(modifier = Modifier.height(16.dp))
            Slider(
                value = chanceInPercentInput.toFloat() / 100,
                onValueChange = { chanceAsFloat ->
                    onChanceInputChange((chanceAsFloat * 100).toInt())
                }
            )
            Text(
                text = "${chanceInPercentInput}%",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent(
                isEditMode = false,
                rewardNameInput = "example reward",
                chanceInPercentInput = 10,
                {},
                {}
            )
        }
    }
}