package com.example.sapcexapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sapcexapplication.presentation.space_detail.CapsuleDetailScreen
import com.example.sapcexapplication.presentation.space_list.CapsuleListScreen
import com.example.sapcexapplication.presentation.ui.theme.SapceXApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SapceXApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CapsuleListScreen.route
                    ) {
                        composable(
                            route = Screen.CapsuleListScreen.route
                        ){
                            CapsuleListScreen(navController = navController )
                        }
                        composable(
                            route = Screen.CapsuleDetailScreen.route + "/{capsuleId}"
                        ){
                            CapsuleDetailScreen(navController = navController)
                            //Screen.CapsuleDetailScreen
                        }
                    }
                }
            }
        }
    }
}
