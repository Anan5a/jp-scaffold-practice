package com.sayempro.scaffoldpractice

import android.content.Context
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext


fun makeToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTopAppBar() {
    val context = LocalContext.current
    val showSubMenu = remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = { Text(text = "Top Bar") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Favourites", Toast.LENGTH_LONG).show()
            }) {
                Icon(Icons.Default.Favorite, contentDescription = null)
            }
            IconButton(onClick = { showSubMenu.value = !showSubMenu.value }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(expanded = showSubMenu.value,
                onDismissRequest = { showSubMenu.value = !showSubMenu.value }) {
                DropdownMenuItem(text = { Text(text = "Close") }, onClick = {
                    makeToast(context, "Closed item")
                    showSubMenu.value = !showSubMenu.value
                }, leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Close, contentDescription = null
                    )
                })
                DropdownMenuItem(text = { Text(text = "Ok") }, onClick = {
                    makeToast(context, "Ok item")
                    showSubMenu.value = !showSubMenu.value
                }, leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Done, contentDescription = null
                    )
                })
                DropdownMenuItem(text = { Text(text = "Edit") }, onClick = {
                    makeToast(context, "Edit item")
                    showSubMenu.value = !showSubMenu.value
                }, leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit, contentDescription = null
                    )
                })


            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    )
}