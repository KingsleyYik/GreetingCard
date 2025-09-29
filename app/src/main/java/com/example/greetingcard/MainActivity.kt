package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                MyApp()
            }
        }
    }
}

// ----------- Main Menu (4 roles) -----------
@Composable
fun FirstPage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome~~~",
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Button(onClick = { navController.navigate("second") }) {
            Text("Student")
        }

        Button(onClick = { navController.navigate("third") }) {
            Text("Admin")
        }

        Button(onClick = { navController.navigate("fourth") }) {
            Text("Instructor")
        }

        Button(onClick = { navController.navigate("fifth") }) {
            Text("Proctor")
        }
    }
}

// ----------- Student Menu ----------
@Composable
fun SecondPage(navController: NavHostController) {
    CommonPage(
        title = "You are a Student！",
        color = Color.Blue,
        onBack = { navController.popBackStack() }
    )
}

// ----------- Admin Menu ----------
@Composable
fun ThirdPage(navController: NavHostController) {
    CommonPage(
        title = "You are an Admin！",
        color = Color.Red,
        onBack = { navController.popBackStack() }
    )
}

// ----------- Instr Menu ----------
@Composable
fun FourthPage(navController: NavHostController) {
    CommonPage(
        title = "You are an Instructor！",
        color = Color.Green,
        onBack = { navController.popBackStack() }
    )
}

// ----------- Proctor Menu ----------
@Composable
fun FifthPage(navController: NavHostController) {
    CommonPage(
        title = "You are a Proctor！",
        color = Color.Magenta,
        onBack = { navController.popBackStack() }
    )
}

// ----------- Common UI ----------
@Composable
fun CommonPage(title: String, color: Color, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, fontSize = 24.sp, color = color)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Back to Main Menu")
        }
    }
}

// ----------- Navigation 設定 ----------
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first") {
        composable("first") { FirstPage(navController) }
        composable("second") { SecondPage(navController) }
        composable("third") { ThirdPage(navController) }
        composable("fourth") { FourthPage(navController) }
        composable("fifth") { FifthPage(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    GreetingCardTheme {
        MyApp()
    }
}
