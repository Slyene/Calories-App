package com.slyene.calories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.slyene.calories.ui.theme.CaloriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CaloriesTheme {
                CaloriesApp()
            }
        }
    }
}