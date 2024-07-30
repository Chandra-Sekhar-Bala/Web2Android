package com.chandra.web2android.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chandra.web2android.R
import com.chandra.web2android.data.model.WebModel

@Preview(showSystemUi = true)
@Composable
private fun WebItemsPreview() {
    WebItems(WebModel("Test", ""), {})
}

@Composable
fun WebItems(data: WebModel, onClick: (WebModel) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp, 12.dp)
            .clickable {
                onClick(data)
            },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)),
        shape = RoundedCornerShape(10, 0 , 80 , 0)
        ,
        border = BorderStroke(0.5.dp, Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = data.name,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily(Font(R.font.outfit_medium)),
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier. fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(0.dp, 0.dp, 16.dp, 0.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}