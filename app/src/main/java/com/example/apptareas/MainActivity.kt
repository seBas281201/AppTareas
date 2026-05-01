package com.example.apptareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apptareas.navigation.AppNavigation
import com.example.apptareas.ui.theme.AppTareasTheme
import com.example.apptareas.ui.theme.ThemeMode
import com.example.apptareas.ui.viewmodel.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTareasTheme {
                AppRoot()
            }
        }
    }
}

@Composable
fun AppRoot() {
    val vm: ThemeViewModel = hiltViewModel()
    val mode = vm.themeMode.collectAsState().value

    val isDark = when (mode) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
    }

    AppTareasTheme(
        darkTheme = isDark,
        dynamicColor = false
    ) {
        AppNavigation()
    }
}
