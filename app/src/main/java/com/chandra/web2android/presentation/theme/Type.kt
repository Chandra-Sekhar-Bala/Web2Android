package com.chandra.web2android.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.chandra.web2android.R

val AppTypography = Typography(
    headlineMedium = TextStyle(
        fontSize = 22.sp,
        fontFamily = FontFamily(Font(R.font.outfit_medium)),
        color = Color.Black
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        color = Color.Gray,
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        color = Color.Black,
    ),
    bodyLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        color = Color.Black,
    )
)