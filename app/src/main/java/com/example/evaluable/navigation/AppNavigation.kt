package com.example.evaluable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluable.screens.*

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Screens.StartM.rute
    )
    {
        composable(Screens.NewG.rute) { NewG(navigationController) }
        composable(Screens.DellG.rute) { DelG(navigationController) }
        composable(Screens.ModG.rute) { ModG(navigationController) }
        composable(Screens.FindG.rute) { FindG(navigationController) }
        composable(Screens.ShowG.rute) { ShowG(navigationController) }
        composable(Screens.StartM.rute) { StartM(navigationController)
        }
    }
}
