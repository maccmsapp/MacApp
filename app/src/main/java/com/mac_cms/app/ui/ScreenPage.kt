package com.mac_cms.app.ui

sealed class ScreenPage(val route: String) {
    data object Home_Page : ScreenPage("home_page")
    data object Category_Page : ScreenPage("category_page")
    data object Detail_Page : ScreenPage("detail_page")
    data object Search_Page : ScreenPage("search_page")
    data object Television_Page : ScreenPage("television_page")
    data object Settings_Page : ScreenPage("settings_page")
}