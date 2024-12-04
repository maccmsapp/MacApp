package com.mac_cms.app.ui.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.mac_cms.app.R
import com.mac_cms.kui.dialog.StandardDialog

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class, ExperimentalTvMaterial3Api::class
)
@Composable
fun ExitAppDialog(showExitDialog: MutableState<Boolean>, exitApp: () -> Unit) {
    if (showExitDialog.value) {
        StandardDialog(
            title = stringResource(R.string.dialog_title),
            text = stringResource(R.string.dialog_exit_message),
            dismissButtonText = stringResource(R.string.dialog_exit_button_dismiss),
            confirmButtonText = stringResource(R.string.dialog_exit_button_confirm),
            onConfirmRequest = { exitApp() },
            onDismissRequest = { showExitDialog.value = false },
            buttonShape = RectangleShape
        )
    }
}



