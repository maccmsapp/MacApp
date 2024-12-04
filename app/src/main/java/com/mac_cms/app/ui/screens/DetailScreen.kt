package com.mac_cms.app.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.core.AppCache
import com.mac_cms.core.beans.MediaItem
import com.mac_cms.design.detail.DetailScreenContent
import com.mac_cms.design.detail.DetailViewModel

@Composable
fun DetailScreen(appState: AppRouter) {
    val mediaItem = remember { AppCache.currentMediaItem }

    if (mediaItem == null) {
        appState.popBackStack()
    } else {
        DetailScreenContent(
            viewModel = DetailViewModel(mediaItem = mediaItem),
            onBackPressed = { appState.popBackStack() },
            navToDetail = { item: MediaItem ->
                appState.navToDetail(item)
            },
        )
    }

}