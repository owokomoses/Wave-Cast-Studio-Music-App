package com.example.wavecastapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wavecastapp.screens.WelcomeScreen
import com.example.wavecastapp.AuthViewModel

/**
 * Screen routes for the WaveCast app
 */
sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
}

/**
 * Main navigation component for the WaveCast app
 */
@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authState = authViewModel.authState.observeAsState()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
    }
}