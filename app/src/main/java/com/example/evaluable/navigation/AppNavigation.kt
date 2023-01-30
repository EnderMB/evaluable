package com.example.evaluable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluable.bd.ViewModel
import com.example.evaluable.screens.*

@Composable
fun AppNavigation(ViewModel: ViewModel) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Screens.StartM.rute) {
        composable(Screens.NewG.rute) { NewG(navigationController, ViewModel()) }
        composable(Screens.DellG.rute) { DelG(navigationController, ViewModel()) }
        composable(Screens.ModG.rute) { ModG(navigationController, ViewModel()) }
        composable(Screens.FindG.rute) { FindG(navigationController, ViewModel()) }
        composable(Screens.ShowG.rute) { ShowG(navigationController, ViewModel()) }
        composable(Screens.StartM.rute) { StartM(navigationController, ViewModel())
        }
    }
}
