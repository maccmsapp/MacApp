package com.mac_cms.app.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mac_cms.app.ui.AppRouter
import com.mac_cms.core.AppCache
import com.mac_cms.core.beans.MediaItem
import com.mac_cms.design.category.CategoryScreenContent

@Composable
fun CategoryScreen(appState: AppRouter) {
    val category = remember {
        AppCache.currentCategory.also {
            if (it != null && it.children?.isEmpty() == true) {
                it.children = mutableListOf(it)
            }
        }
    }

    if (category == null) {
        appState.popBackStack()
    } else {
        CategoryScreenContent(
            category = category,
            onBackPressed = { appState.popBackStack() },
            navToDetail = { mediaItem: MediaItem ->
                appState.navToDetail(mediaItem)
            },
            navToSearch = { appState.navToSearch() }
        )
    }
}