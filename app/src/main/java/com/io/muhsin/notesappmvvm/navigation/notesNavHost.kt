package com.io.muhsin.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.io.muhsin.notesappmvvm.screens.Add
import com.io.muhsin.notesappmvvm.screens.Main
import com.io.muhsin.notesappmvvm.screens.Note
import com.io.muhsin.notesappmvvm.screens.Start

sealed class NavRoute(val route :String){
    object Start : NavRoute ("start_screen")
    object Main : NavRoute ("main_screen")
    object Add: NavRoute ("add_screen")
    object Note : NavRoute ("note_screen")
}


@Composable
fun notesNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Start.route){

        composable(NavRoute.Start.route){ Start(navController = navController)}
        composable(NavRoute.Main.route){ Main(navController = navController) }
        composable(NavRoute.Add.route){ Add(navController = navController)}
        composable(NavRoute.Note.route){ Note(navController = navController)}
    }
}