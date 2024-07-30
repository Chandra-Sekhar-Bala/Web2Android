package com.chandra.web2android.presentation.ui.addWeb

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.poxscan.wallet.presentation.ui.wallet.ButtonFilled
import io.poxscan.wallet.presentation.ui.wallet.TopAppBar

@Preview(showSystemUi = true)
@Composable
private fun AddWebsitesPrev() {
    AddWebsites({})
}

@Composable
fun AddWebsites(onSubmitClick: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar("Add Websites") {
            }
        },
        bottomBar = {
            ButtonFilled(text = "Add", Modifier.padding(0.dp, 16.dp)) {
                onSubmitClick()
            }
        },
        content = { paddingValues ->
            InputContent(Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun InputContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(16.dp)
    ) {
        Text(text = "Title", style = MaterialTheme.typography.bodyLarge)
        var title by remember { mutableStateOf("") }
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            placeholder = { Text("Enter website title") },
            textStyle = MaterialTheme.typography.bodyLarge,
        )

        Text(text = "Address", style = MaterialTheme.typography.bodyLarge)
        var webAddress by remember { mutableStateOf("") }
        OutlinedTextField(
            value = webAddress,
            onValueChange = { webAddress = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            placeholder = { Text("Enter website Address") },
            textStyle = MaterialTheme.typography.bodyLarge,
        )
    }
}
