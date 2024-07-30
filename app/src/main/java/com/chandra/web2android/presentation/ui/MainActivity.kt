package com.chandra.web2android.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.chandra.web2android.presentation.theme.Web2AndroidTheme
import com.chandra.web2android.presentation.ui.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Web2AndroidTheme {
                App()
            }
        }
    }

}

@Composable
fun App() {

    HomeScreen(listItems = emptyList(), onItemClick = {

    }, onAddBtnClick = {

    })
}
