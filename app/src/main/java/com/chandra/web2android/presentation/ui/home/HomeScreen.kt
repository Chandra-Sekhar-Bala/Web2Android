package com.chandra.web2android.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chandra.web2android.data.model.WebModel
import com.chandra.web2android.presentation.theme.Colors
import io.poxscan.wallet.presentation.ui.wallet.TopAppBar

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(
        listOf(
            WebModel("Test", ""),
            WebModel("Test", ""),
            WebModel("Test", ""),
        ), {}, {})
}

@Composable
fun HomeScreen(
    listItems: List<WebModel>,
    onItemClick: (WebModel) -> Unit,
    onAddBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, 0.dp)
            .background(color = Color.White)
    ) {
        Column {
            TopAppBar("Saved Items", false) {

            }
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(listItems) { item ->
                    WebItems(item, onItemClick)
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            shape = RoundedCornerShape(60),
            containerColor = Colors.BlueBell,
            onClick = { onAddBtnClick() }
        ) {
            Image(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}