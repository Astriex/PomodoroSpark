package com.astriex.pomodorospark.feature_rewards.presenter.composables

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.astriex.pomodorospark.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScrollToTopFab(
    modifier: Modifier,
    coroutineScope: CoroutineScope,
    listState: LazyListState
) {
    FloatingActionButton(
        onClick = {
            coroutineScope.launch { listState.animateScrollToItem(index = 0) }
        },
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ExpandLess,
            contentDescription = stringResource(R.string.scroll_to_top),
        )
    }
}