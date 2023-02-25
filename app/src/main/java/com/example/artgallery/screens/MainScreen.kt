package com.example.artgallery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.artgallery.MainViewModel
import com.example.artgallery.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allArts = viewModel.allArts.observeAsState(listOf()).value
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ArtsScreen(allArts)
    }

}

@Composable
fun ArtsScreen(allArts: List<Movies>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(allArts){art->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ArtCard(item = art)
            }
        }
    }
}
@Composable
fun ArtCard(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(100.dp),
            painter = rememberAsyncImagePainter(model = item.image.medium),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(text = item.id.toString())
        Text(text = item.name)
    }
}