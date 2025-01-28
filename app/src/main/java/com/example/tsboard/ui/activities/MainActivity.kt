package com.example.tsboard.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tsboard.ui.components.BottomNavItem
import com.example.tsboard.ui.components.TsboardBottomNavigationBar
import com.example.tsboard.ui.components.TsboardTopAppBar
import com.example.tsboard.ui.components.drawer.DrawerContent
import com.example.tsboard.ui.theme.TsboardTheme

// 메인 액티비티 정의
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var drawerState = rememberDrawerState(DrawerValue.Closed)
            val coroutineScope = rememberCoroutineScope()

            ModalNavigationDrawer(drawerState = drawerState, drawerContent = { DrawerContent() }) {
                TsboardTheme(darkTheme = true) {
                    val scrollBehavior =
                        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                    val navController = rememberNavController()

                    Scaffold(
                        topBar = { TsboardTopAppBar(scrollBehavior, drawerState, coroutineScope) },
                        bottomBar = { TsboardBottomNavigationBar(navController) },
                        modifier = Modifier
                            .nestedScroll(scrollBehavior.nestedScrollConnection)
                            .fillMaxSize()
                    ) { innerPadding ->
                        NavigationGraph(navController)
                    }
                }
            }
        }
    }
}

// 하단 버튼 클릭시 보여지는 부분 정의
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Home route", style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
            }
        }

        composable(BottomNavItem.Feed.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Feed route", style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
            }
        }

        composable(BottomNavItem.Profile.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Profile route", style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
            }
        }
    }
}
