package com.example.tsboard.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// 상단 AppBar 영역 설정
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TsboardTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {

    var hasNotification by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(
                text = "TSBOARD",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Normal
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    if (drawerState.isOpen) {
                        drawerState.close()
                    } else {
                        drawerState.open()
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            IconButton(onClick = {
                hasNotification = !hasNotification
            }) {
                Icon(
                    imageVector = if (hasNotification) Icons.Filled.Notifications else Icons.Outlined.Notifications,
                    contentDescription = "notification",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

        },
        scrollBehavior = scrollBehavior,
    )
}