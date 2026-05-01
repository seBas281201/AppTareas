package com.example.apptareas.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apptareas.ui.ajustes.AjustesScreen
import com.example.apptareas.ui.editar_tareas.EditarTareaScreen
import com.example.apptareas.ui.lista_tareas.ListaTareasScreen
import com.example.apptareas.ui.registrar_tareas.RegistrarTareasScreen
import com.example.apptareas.ui.ver_detalle.DetalleTareaScreen
import com.example.apptareas.ui.viewmodel.TareaViewModel

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ListaTareasScreen"
    ){
        composable("ListaTareasScreen"){
            ListaTareasScreen(navController = navController)
        }

        composable("RegistrarTareasScreen"){
            RegistrarTareasScreen(navController = navController)
        }

        composable(
            route = "EditarTareasScreen/{id}",
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ) { navBackStackEntry ->

            val tareaId = navBackStackEntry.arguments?.getInt("id") ?: 0
            val viewModel : TareaViewModel = hiltViewModel()

            EditarTareaScreen(
                navController = navController,
                tareaId = tareaId,
                viewModel = viewModel
            )
        }

        composable(
            route = "DetalleTareaScreen/{id}",
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ) { navBackStackEntry ->

            val tareaId = navBackStackEntry.arguments?.getInt("id") ?: return@composable
            val viewModel : TareaViewModel = hiltViewModel()

            DetalleTareaScreen(
                viewModel = viewModel,
                navController = navController,
                tareaId = tareaId
            )
        }

        composable(
            route = "AjustesScreen"
        ) {
            AjustesScreen(navController = navController)
        }

    }

}