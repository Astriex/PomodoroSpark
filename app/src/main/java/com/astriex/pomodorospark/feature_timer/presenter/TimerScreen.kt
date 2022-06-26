package com.astriex.pomodorospark.feature_timer.presenter

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.common.presenter.composables.DefaultTopAppBar
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun TimerScreen(navController: NavController) {
    ScreenContent(navController)
}

@Composable
private fun ScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            DefaultTopAppBar(title = "Timer")
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(id = R.string.timer))
        }
    }
}

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent(rememberNavController())
        }
    }
}
