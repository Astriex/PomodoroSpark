package com.astriex.pomodorospark.feature_rewards.presenter.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.feature_rewards.data.local.util.defaultIcon
import com.astriex.pomodorospark.feature_rewards.data.local.util.rewardIcons
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun RewardItem(
    reward: Reward,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {},
        elevation = 5.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                imageVector = rewardIcons[reward.iconKey] ?: defaultIcon,
                contentDescription = null
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = reward.title,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = stringResource(id = R.string.chance) + ": ${reward.chanceInPercent.toString()}%",
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RewardItemPreview() {
    PomodoroSparkTheme {
        Surface {
            RewardItem(Reward(iconKey = "Key", title = "Title", 10, isUnlocked = false))
        }
    }
}