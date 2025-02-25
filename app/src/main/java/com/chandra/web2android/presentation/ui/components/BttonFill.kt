package com.chandra.web2android.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chandra.web2android.presentation.theme.Colors

@Preview()
@Composable
private fun ButtonFilledPrev() {
    ButtonFilled("Crete Wallet", enabled = false) {}
}

@Composable
fun ButtonFilled(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Colors.DeepBlue else Color.Gray
        ),
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp),
            color = if (enabled) Color.White else Color.LightGray
        )
    }
}