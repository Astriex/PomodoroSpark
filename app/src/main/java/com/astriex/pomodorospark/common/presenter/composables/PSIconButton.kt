package com.astriex.pomodorospark.common.presenter.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.ui.IconButtonRounderCornerSize
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme


@Composable
fun PSIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val iconButtonBackground = if (isSystemInDarkTheme()) Color.Gray else Color.LightGray
    //val iconColor = if (isSystemInDarkTheme()) Color.Gray else Color.LightGray
    IconButton(
        onClick = { /*TODO*/ },
        modifier = modifier
            .clip(RoundedCornerShape(IconButtonRounderCornerSize))
            .background(iconButtonBackground)
    ) {
        content()
    }
}

@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            Box(modifier = Modifier.padding(64.dp), contentAlignment = Alignment.Center) {
                PSIconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = stringResource(id = R.string.select_icon)
                    )
                }
            }
        }
    }
}
