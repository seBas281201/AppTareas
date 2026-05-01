package com.example.apptareas.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptareas.ui.theme.ThemeMode
import com.example.apptareas.ui.theme.ThemePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val prefs: ThemePreferences
) : ViewModel() {
    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode : StateFlow<ThemeMode> = _themeMode

    init {
        viewModelScope.launch {
            prefs.themeModeFlow.collect {
                _themeMode.value = it
            }
        }
    }

    fun updateTheme (mode : ThemeMode){
        viewModelScope.launch {
            prefs.setTheme(mode)
        }
    }
}