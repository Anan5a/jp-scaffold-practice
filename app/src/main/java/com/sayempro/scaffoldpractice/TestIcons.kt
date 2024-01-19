package com.sayempro.scaffoldpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun TestIcons(padding: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(padding),

        ) {
        val icon1 = painterResource(id = R.drawable.ic_time)
        Icon(painter = icon1, contentDescription = null)

        Icon(imageVector = Icons.Default.Build, contentDescription = null)
        Icon(imageVector = Icons.Outlined.Build, contentDescription = null)
        Icon(imageVector = Icons.Filled.Build, contentDescription = null)
        Icon(imageVector = Icons.Sharp.Build, contentDescription = null)

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Sharp.AccountBox, contentDescription = null)

        }
    }
}