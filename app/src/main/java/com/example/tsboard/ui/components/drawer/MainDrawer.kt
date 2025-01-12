package com.example.tsboard.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tsboard.ui.theme.TsboardTheme

// 드로워 영역
@Composable
fun DrawerContent() {
    TsboardTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.secondary)
                .width(280.dp)
                .padding(16.dp)
        ) {
            ProfileSection(
                imageUrl = "https://tsboard.dev/upload/profile/2024/06/07/Ixdf7aVPzVGki9V2QWmge.avif",
                name = "sirini",
                email = "sirini@gmail.com",
                level = 9,
                point = 1000
            )
        }
    }
}
