package com.mac_cms.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mac_cms.app.ui.screens.CategoryScreen
import com.mac_cms.app.ui.screens.DetailScreen
import com.mac_cms.app.ui.screens.HomeScreen
import com.mac_cms.app.ui.screens.SearchScreen
import com.mac_cms.app.ui.screens.SettingsScreen
import com.mac_cms.app.ui.screens.TelevisionScreen
import com.mac_cms.core.AppCache
import com.mac_cms.core.beans.Category
import com.mac_cms.core.beans.MediaItem

@Composable
fun AppNav(
    appState: AppRouter = rememberAppState(),
    exitApp: () -> Unit
) {
    NavHost(
        navController = appState.navController,
        startDestination = ScreenPage.Home_Page.route
    ) {
        composable(ScreenPage.Home_Page.route) {
            HomeScreen(exitApp = exitApp, appState = appState)
        }

        composable(ScreenPage.Detail_Page.route) {
            DetailScreen(appState = appState)
        }

        composable(ScreenPage.Category_Page.route) {
            CategoryScreen(appState = appState)
        }

        composable(ScreenPage.Television_Page.route) {
            TelevisionScreen(appState = appState)
        }

        composable(ScreenPage.Search_Page.route) {
            SearchScreen(appState = appState)
        }

        composable(ScreenPage.Settings_Page.route) {
            SettingsScreen(appState = appState)
        }
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
): AppRouter {
    val appState = remember(navController) { AppRouter(navController) }
    return appState
}

/**
 *
 */
class AppRouter(
    val navController: NavHostController,
) {

    fun navToHome() {
        navController.navigate(ScreenPage.Home_Page.route)
    }

    fun navToDetail(mediaItem: MediaItem) {
        AppCache.currentMediaItem = mediaItem
        navController.navigate(ScreenPage.Detail_Page.route)
    }

    fun navToCategory(category: Category) {
        AppCache.currentCategory = category
        navController.navigate(ScreenPage.Category_Page.route)
    }

    fun navToTelevision() {
        navController.navigate(ScreenPage.Television_Page.route)
    }


    fun navToSearch() {
        navController.navigate(ScreenPage.Search_Page.route)
    }

    fun navToSettings() {
        navController.navigate(ScreenPage.Settings_Page.route)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}