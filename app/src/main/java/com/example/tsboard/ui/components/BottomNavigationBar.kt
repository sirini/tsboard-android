package com.example.tsboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tsboard.R
import com.example.tsboard.ui.theme.TsboardTheme

// 하단 네비게이션 버튼 바 정의
@Composable
fun TsboardBottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Feed,
        BottomNavItem.Profile
    )
    TsboardTheme(darkTheme = true) {
        NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    icon = item.icon,
                    selected = currentDestination == item.route,
                    modifier = Modifier.background(MaterialTheme.colorScheme.background).clip(shape = CircleShape),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.secondary,
                        selectedTextColor = MaterialTheme.colorScheme.tertiary,
                        unselectedTextColor = MaterialTheme.colorScheme.secondary,
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

// 하단 버튼들 정의
sealed class BottomNavItem(val title: String, val icon: @Composable () -> Unit, val route: String) {
    object Home : BottomNavItem("Home",
        { Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home", modifier = Modifier.size(32.dp)) }, "home")
    object Feed : BottomNavItem("Feed",
        { Icon(painter = painterResource(id = R.drawable.chatbubble_ellipses_outline), contentDescription = "Feed", modifier = Modifier.size(32.dp)) }, "feed")
    object Profile : BottomNavItem("Profile",
        { Icon(painter = painterResource(id = R.drawable.person_circle_sharp), contentDescription = "Profile", modifier = Modifier.size(32.dp)) }, "profile")
}