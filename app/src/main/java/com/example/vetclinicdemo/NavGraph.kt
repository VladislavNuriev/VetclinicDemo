package com.example.vetclinicdemo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clients.ui.ClientsScreen
import com.example.new_client.ui.NewClientScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Clients.route
    ) {
        composable(Screen.Clients.route) {
            ClientsScreen (
                onAddClientClick = {
                    navController.navigate(Screen.NewClient.route)
                },
                onClientClick = {

                }
            )
        }
        composable(route = Screen.NewClient.route) {
            NewClientScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {
    data object Clients : Screen("clients")
    data object NewClient : Screen("new_client")
}