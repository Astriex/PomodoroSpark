package com.astriex.pomodorospark.common.presenter.composables

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable


@Composable
fun CustomTopAppBar(title: String) {
    TopAppBar(
        title = { Text(text = title) }
    )
}