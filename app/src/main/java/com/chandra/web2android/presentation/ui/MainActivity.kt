package com.chandra.web2android.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chandra.web2android.data.model.WebModel
import com.chandra.web2android.presentation.theme.Web2AndroidTheme
import com.chandra.web2android.presentation.ui.addWeb.AddWebsites
import com.chandra.web2android.presentation.ui.home.HomeScreen
import com.chandra.web2android.presentation.ui.utils.logThis
import com.chandra.web2android.presentation.ui.utils.toast

class MainActivity : ComponentActivity() {
    val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Web2AndroidTheme {
                App(viewModel)
            }
        }
    }

}

@Composable
fun App(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(route = Routes.HOME_SCREEN) {
            HomeScreen(
                // TODO: Need a real data source, which fetches data from Database
                listOf(
                    WebModel("StackOverflow", ""),
                    WebModel("Medium", ""),
                    WebModel("BitBucket", ""),
                ),
                onItemClick = { item ->
                    logThis("ITem clicked $item")
                    context.toast("Coming soon")
                }, onAddBtnClick = {
                    navController.navigate(Routes.ADD_WEBSITE)
                })
        }
        composable(route = Routes.ADD_WEBSITE) {
            AddWebsites(viewModel, onSubmitClick = {
                navController.navigateUp()
            }, onBackClick = {
                navController.navigateUp()
            }
            )
        }
    }
}
