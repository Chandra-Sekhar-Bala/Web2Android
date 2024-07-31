package com.chandra.web2android.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chandra.web2android.presentation.ui.utils.logThis
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    init {

    }

    fun saveToDB(title: String, address: String) {
        viewModelScope.launch {
            // TODO: Save to Database
            logThis("Data should be now saved to database $title and $address")
        }
    }
}