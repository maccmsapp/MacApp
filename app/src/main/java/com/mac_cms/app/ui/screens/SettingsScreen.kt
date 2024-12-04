package com.mac_cms.app.ui.screens

import androidx.compose.runtime.Composable
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.design.settings.SettingsScreenContent

@Composable
fun SettingsScreen(appState: AppRouter) {
    SettingsScreenContent { appState.popBackStack() }
}