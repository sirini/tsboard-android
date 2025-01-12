package com.example.tsboard.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.tsboard.ui.components.TsboardTopAppBar
import com.example.tsboard.ui.components.drawer.DrawerContent
import com.example.tsboard.ui.theme.TsboardTheme

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

                    Scaffold(
                        topBar = { TsboardTopAppBar(scrollBehavior, drawerState, coroutineScope) },
                        modifier = Modifier
                            .nestedScroll(scrollBehavior.nestedScrollConnection)
                            .fillMaxSize()
                    ) { innerPadding ->
                        Greeting(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello from TSBOARD Android app!\n\nComing Sooooooooooon!",
            )
        }
    }
}

