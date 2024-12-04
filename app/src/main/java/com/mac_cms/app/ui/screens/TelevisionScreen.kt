package com.mac_cms.app.ui.screens

import androidx.compose.runtime.Composable
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.design.television.TelevisionScreenContent

@Composable
fun TelevisionScreen(appState: AppRouter) {
    TelevisionScreenContent(
        navToSettings = { appState.navToSettings() },
        onBackPress = { appState.popBackStack() })
}