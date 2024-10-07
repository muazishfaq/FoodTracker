package com.gms.foodtracker

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
import com.gms.core.navigation.Route
import com.gms.foodtracker.navigation.navigate
import com.gms.foodtracker.ui.theme.FoodTrackerTheme
import com.gms.onboarding_presentation.gender.GenderScreen
import com.gms.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Route.WELCOME) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(route = Route.AGE) {

                        }
                        composable(route = Route.GENDER) {
                            GenderScreen(onNavigation = navController::navigate)
                        }
                        composable(route = Route.HEIGHT) {

                        }
                        composable(route = Route.WEIGHT) {

                        }
                        composable(route = Route.NUTRIENT_GOAL) {

                        }
                        composable(route = Route.ACTIVITY) {

                        }
                        composable(route = Route.GOAL) {

                        }
                        composable(route = Route.TRACKER_OVERVIEW) {

                        }
                        composable(route = Route.SEARCH) {

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodTrackerTheme {
        Greeting("Android")
    }
}