package com.example.apptareas.ui.theme

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apptareas.ui.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeSelector() {

    val vm: ThemeViewModel = hiltViewModel()
    val mode by vm.themeMode.collectAsState()

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val opciones = listOf(
        ThemeMode.SYSTEM,
        ThemeMode.LIGHT,
        ThemeMode.DARK
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = it
        }
    ) {
        OutlinedTextField(
            readOnly = true,
            value = when (mode) {
                ThemeMode.SYSTEM -> "Sistema"
                ThemeMode.LIGHT -> "Claro"
                ThemeMode.DARK -> "Oscuro"
            },
            onValueChange = {},
            label = {
                Text(text = "Tema")
            },
            modifier = Modifier.menuAnchor(
                type = MenuAnchorType.PrimaryNotEditable,
                enabled = true
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            opciones.forEach { mode ->
                DropdownMenuItem(
                    text = {
                        Text(text = when (mode) {
                            ThemeMode.SYSTEM -> "Sistema"
                            ThemeMode.LIGHT -> "Claro"
                            ThemeMode.DARK -> "Oscuro"
                        })
                    },
                    onClick = {
                        vm.updateTheme(mode)
                        expanded = false
                    }
                )
            }
        }
    }
}