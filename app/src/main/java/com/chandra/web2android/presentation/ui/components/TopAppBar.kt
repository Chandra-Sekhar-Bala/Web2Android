package io.poxscan.wallet.presentation.ui.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chandra.web2android.R
import com.chandra.web2android.presentation.theme.Colors

@Preview(showSystemUi = true)
@Composable
private fun TopAppBarPrev() {
    TopAppBar("Create Account") {}
}

@Composable
fun TopAppBar(
    text: String = "",
    isBackVisible: Boolean = true,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0, 0, 24, 24))
            .padding(16.dp, 12.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isBackVisible) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button",
                modifier = Modifier
                    .align(
                        Alignment.CenterStart
                    )
                    .clickable {
                        onBackClick()
                    }
            )
        }
        Text(
            text = text, style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.outfit_medium)),
            ), color = Color.Black
        )
    }
}