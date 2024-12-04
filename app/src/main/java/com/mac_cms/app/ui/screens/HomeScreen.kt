package com.mac_cms.app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.app.ui.dialog.ExitAppDialog
import com.mac_cms.design.home.HomeScreenContent

@Composable
fun HomeScreen(
    exitApp: () -> Unit,
    appState: AppRouter
) {

    val showExitDialog = remember { mutableStateOf(false) }

    BackHandler {
        showExitDialog.value = true
    }

    ExitAppDialog(showExitDialog = showExitDialog, exitApp = exitApp)

    HomeScreenContent(
        onBackPressed = { showExitDialog.value = true },
        navToSettings = { appState.navToSettings() },
        navToDetail = { appState.navToDetail(it) },
        navToCategory = { appState.navToCategory(it) },
        navToSearch = { appState.navToSearch() },
        navToTelevision = { appState.navToTelevision() },
    )
}