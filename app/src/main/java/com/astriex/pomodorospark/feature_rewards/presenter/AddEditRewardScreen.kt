package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.common.presenter.composables.CustomTopAppBar
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun AddEditRewardScreen(viewModel: AddEditRewardViewModel = hiltViewModel()) {
    val rewardNameInput by viewModel.rewardNameInput.observeAsState()
    val isEdit: Boolean = viewModel.isEditMode

    ScreenContent(
        isEditMode = isEdit,
        rewardNameInput = rewardNameInput,
        onRewardNameInputChange = viewModel::onRewardNameInputChange
    )
}

@Composable
fun ScreenContent(
    isEditMode: Boolean,
    rewardNameInput: String?,
    onRewardNameInputChange: (input: String) -> Unit
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
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = rewardNameInput ?: "",
                onValueChange = onRewardNameInputChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.reward_name))
                },
                singleLine = true
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
                isEditMode = false, rewardNameInput = "example reward", {}
            )
        }
    }
}