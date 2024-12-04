package com.mac_cms.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.mac_cms.kui.theme.KMaterialTheme

@Composable
fun MacFreeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    KMaterialTheme(darkTheme = darkTheme, content = content)
}