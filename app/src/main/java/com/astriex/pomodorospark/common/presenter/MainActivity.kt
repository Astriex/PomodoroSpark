package com.astriex.pomodorospark.common.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.astriex.pomodorospark.common.presenter.util.BottomNavDestinations
import com.astriex.pomodorospark.common.presenter.util.FullScreenDestinations
import com.astriex.pomodorospark.common.presenter.util.items
import com.astriex.pomodorospark.feature_rewards.presenter.AddEditRewardScreen
import com.astriex.pomodorospark.feature_rewards.presenter.RewardsScreen
import com.astriex.pomodorospark.feature_timer.presenter.TimerScreen
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomodoroSparkTheme {
                ScreenContent()
            }
        }
    }
}

@Composable
private fun ScreenContent() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.route
                            )
                        },
                        label = { Text(text = stringResource(id = screen.resourceId)) },
                        alwaysShowLabel = false,
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavDestinations.RewardsScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavDestinations.TimerScreen.route) {
                TimerScreen(navController)
            }
            composable(BottomNavDestinations.RewardsScreen.route) {
                RewardsScreen(navController)
            }
            composable(FullScreenDestinations.AddEditRewardScreen.route) {
                AddEditRewardScreen(navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PomodoroSparkTheme {
        ScreenContent()
    }
}
