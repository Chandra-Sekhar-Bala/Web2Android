package com.chandra.web2android.di

import com.chandra.web2android.presentation.ui.MainViewModel
import org.koin.dsl.module

val appModules = module {
    single { MainViewModel() }
}