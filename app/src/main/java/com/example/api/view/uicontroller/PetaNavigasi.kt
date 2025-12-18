package com.example.api.view.uicontroller


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.api.view.EntrySiswaScreen
import com.example.api.view.route.DestinasiEntry
import com.example.api.view.route.DestinasiHome


@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(navController: NavHostController,
                 modifier: Modifier = Modifier) {
    NavHost(navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier) {
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = {
                navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiEntry.route}/${it}")
                })
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route)})
        }
    }
}

@Composable
fun HomeScreen(navigateToItemEntry: () -> Unit, navigateToItemUpdate: () -> Unit) {
    TODO("Not yet implemented")
}