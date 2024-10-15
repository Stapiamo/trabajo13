package com.example.trabajo13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trabajo13.View.ImcView

import com.example.trabajo13.View.PatientsView
import com.example.trabajo13.ViewModel.PatientsViewModel
import com.example.trabajo13.ui.theme.Trabajo13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Trabajo13Theme {
            val patientsViewModel: PatientsViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home" ){
                    composable(route = "home") { PatientsView (navController,viewModel = patientsViewModel)}
                    composable(route = "imc") {ImcView(navController)}
                }
            }
        }
    }
}