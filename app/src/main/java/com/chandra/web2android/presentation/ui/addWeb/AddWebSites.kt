package com.chandra.web2android.presentation.ui.addWeb

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chandra.web2android.presentation.ui.MainViewModel
import com.chandra.web2android.presentation.ui.components.ButtonFilled
import io.poxscan.wallet.presentation.ui.wallet.TopAppBar

@Preview(showSystemUi = true)
@Composable
private fun AddWebsitesPrev() {
//    AddWebsites(null, {}, {})
}

@Composable
fun AddWebsites(
    viewModel: MainViewModel,
    onSubmitClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LocalContext.current
    val view = LocalView.current
    val insets = WindowInsets.ime
    var title by remember { mutableStateOf("") }
    var webAddress by remember { mutableStateOf("") }
    var isTitleValid by remember { mutableStateOf(false) }
    var isWebAddressValid by remember { mutableStateOf(false) }
    isTitleValid = title.isNotBlank()
    isWebAddressValid = android.util.Patterns.WEB_URL.matcher(webAddress).matches()
    val isButtonEnabled = isTitleValid && isWebAddressValid

    Scaffold(
        topBar = {
            TopAppBar("Add Websites") {
                onBackClick()
            }
        },
        bottomBar = {
            ButtonFilled(
                text = "Add",
                modifier = Modifier
                    .padding(16.dp)
                    .imePadding(),
                enabled = isButtonEnabled
            ) {
                if (isButtonEnabled) {
                    viewModel.saveToDB(title, webAddress)
                    onSubmitClick()
                }
            }
        },
        content = { paddingValues ->
            InputContent(
                modifier = Modifier
                    .padding(paddingValues)
                    .navigationBarsPadding()
                    .statusBarsPadding()
                    .imePadding(),
                title = title,
                onTitleChange = { title = it },
                webAddress = webAddress,
                onWebAddressChange = { webAddress = it }
            )
        }
    )
}

@Composable
fun InputContent(
    modifier: Modifier,
    title: String,
    onTitleChange: (String) -> Unit,
    webAddress: String,
    onWebAddressChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(16.dp)
    ) {
        Text(text = "Title", style = MaterialTheme.typography.bodyLarge)
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            placeholder = { Text("Enter website title") },
            textStyle = MaterialTheme.typography.bodyLarge,
        )

        Text(text = "Address", style = MaterialTheme.typography.bodyLarge)
        OutlinedTextField(
            value = webAddress,
            onValueChange = onWebAddressChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            placeholder = { Text("Enter website address") },
            textStyle = MaterialTheme.typography.bodyLarge,
        )
    }
}
