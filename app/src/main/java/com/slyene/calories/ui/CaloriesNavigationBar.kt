package com.slyene.calories.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CaloriesNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier, windowInsets = WindowInsets.navigationBars
    ) {
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Info, contentDescription = ""
            )
        }, label = { Text(text = "Label") })

        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Info, contentDescription = ""
            )
        }, label = { Text(text = "Label") })

        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Info, contentDescription = ""
            )
        }, label = { Text(text = "Label") })

        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Info, contentDescription = ""
            )
        }, label = { Text(text = "Label") })
    }
}