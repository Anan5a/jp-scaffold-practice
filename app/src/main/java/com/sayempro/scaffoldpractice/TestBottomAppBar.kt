package com.sayempro.scaffoldpractice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


enum class TestBottomAppBarSelectedItem {
    Settings, Add, Edit
}

@Composable
fun TestBottomAppBar(state: SnackbarHostState) {
    val selectedItem = remember {
        mutableStateOf(TestBottomAppBarSelectedItem.Add)
    }
    val ctx = LocalContext.current
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        actions = {
//            Text(text = "Bottom bar", fontSize = 20.sp)
            IconButton(onClick = {
                selectedItem.value = TestBottomAppBarSelectedItem.Settings
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = if (selectedItem.value == TestBottomAppBarSelectedItem.Settings) Color.Red else Color.White
                )
            }
            IconButton(onClick = {
                selectedItem.value = TestBottomAppBarSelectedItem.Add

            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = if (selectedItem.value == TestBottomAppBarSelectedItem.Add) Color.Red else Color.White
                )
            }
            IconButton(onClick = {
                selectedItem.value = TestBottomAppBarSelectedItem.Edit

            }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = if (selectedItem.value == TestBottomAppBarSelectedItem.Edit) Color.Red else Color.White
                )
            }

        },
        floatingActionButton = { TestFab(ctx, state) },
    )
//    {
//
////            innerPadding ->
////        Text(
////            modifier = Modifier.padding(innerPadding),
////            text = "Example of a scaffold with a bottom app bar."
////        )
//
////        Text(text = "some text", modifier = Modifier.padding(it))
//    }
}

