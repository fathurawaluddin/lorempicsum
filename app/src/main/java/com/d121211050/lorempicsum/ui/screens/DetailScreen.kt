// DetailScreen.kt
package com.d121211050.lorempicsum.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.d121211050.lorempicsum.model.LoremPicsumPhoto

@Composable
fun DetailScreen(photo: LoremPicsumPhoto, onNavigateUp: () -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            // Display the image
            Image(
                painter = rememberAsyncImagePainter(model = photo.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )
        }
        item {
            // Display other information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "ID: ${photo.id}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Author: ${photo.author}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Width: ${photo.width}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Height: ${photo.height}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
