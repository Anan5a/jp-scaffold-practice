package com.sayempro.scaffoldpractice

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TestFab(ctx: Context, state: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()
    FloatingActionButton(
        onClick = {
//        makeToast(ctx, "The FAB has been clicked!")
            coroutineScope.launch {
                val action = state.showSnackbar(
                    message = "This is a yummy snack-bar",
                    duration = SnackbarDuration.Short,
                    actionLabel = "Eat now!"
                )
                when (action) {
                    SnackbarResult.ActionPerformed -> makeToast(ctx, "Thanks for eating me!")
                    SnackbarResult.Dismissed -> makeToast(ctx, "I am sad")
                }
            }
        },

        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(defaultElevation = 10.dp)

    ) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
    }
}