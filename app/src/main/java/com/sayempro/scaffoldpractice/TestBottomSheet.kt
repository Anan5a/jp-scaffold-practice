package com.sayempro.scaffoldpractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestBottomSheet() {
    val bottomSheetState = rememberBottomSheetScaffoldState(
        SheetState(skipPartiallyExpanded = true, skipHiddenState = false)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        topBar = { TestTopAppBar() },
        scaffoldState = bottomSheetState,
        //sheet content is inside the sheet
        sheetContent = {
            Column {
                Text(
                    text = "This is some large ass text inside the bottom sheet content...",
                    fontSize = 25.sp
                )
                Text(
                    text = "This is some large ass text inside the bottom sheet content...",
                    fontSize = 25.sp
                )
                Text(
                    text = "This is some large ass text inside the bottom sheet content...",
                    fontSize = 25.sp
                )
                Text(
                    text = "This is some large ass text inside the bottom sheet content...",
                    fontSize = 25.sp
                )
            }
        },
        sheetPeekHeight = 0.dp,
        sheetSwipeEnabled = true,
//sheetTonalElevation = 500.dp
    ) {
        //this content is normal content
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    if (!bottomSheetState.bottomSheetState.isVisible) bottomSheetState.bottomSheetState.expand()
                    else bottomSheetState.bottomSheetState.hide()
                }

            }) {
                Text(text = "Click me to see the sheet!")
            }
        }
    }
}