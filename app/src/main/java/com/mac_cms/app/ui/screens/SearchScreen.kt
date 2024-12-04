package com.mac_cms.app.ui.screens

import androidx.compose.runtime.Composable
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.design.search.SearchScreenContent

@Composable
fun SearchScreen(appState: AppRouter) {
    SearchScreenContent(
        onBackPress = { appState.popBackStack() },
        onItemClick = { appState.navToDetail(it) },
    )
}