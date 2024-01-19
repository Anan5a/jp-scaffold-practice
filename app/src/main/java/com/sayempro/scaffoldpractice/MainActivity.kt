package com.sayempro.scaffoldpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sayempro.scaffoldpractice.ui.theme.ScaffoldPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestScaffold()
//                    TestBottomSheet()
                }
            }
        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScaffold() {
    val state = remember {
        SnackbarHostState()
    }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = state) },
        topBar = { TestTopAppBar() },
        bottomBar = { TestBottomAppBar(state) },
//        floatingActionButton = { TestFab(LocalContext.current)},
//        floatingActionButtonPosition = FabPosition.Center,

//        content = { PaddingValues(10.dp) },

    ) { padding ->

        TestIcons(padding)
    }

}