package com.example.tsboard.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tsboard.ui.theme.TsboardTheme

@Composable
fun ProfileSection(imageUrl: String, name: String, email: String, level: Int, point: Int) {
    TsboardTheme(darkTheme = true) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .background(Color.LightGray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                name,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Text(
                email,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Level: $level, Point: $point",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}