package com.mac_cms.app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PowerManager
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mac_cms.app.ui.AppNav
import com.mac_cms.app.ui.theme.MacFreeTheme
import com.mac_cms.klibs.base.BaseActivity
import com.mac_cms.klibs.isPhone
import com.mac_cms.kui.theme.KColorScheme

class MainActivity : BaseActivity() {
    private lateinit var powerManager: PowerManager
    private lateinit var wakeLock: PowerManager.WakeLock

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (isPhone) {
            // 手机强制竖屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        // 保持屏幕常亮
        powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, packageName)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContent {
            MacFreeTheme(darkTheme = true) {
                Box(
                    modifier = Modifier.fillMaxSize().background(
                        color = KColorScheme.background
                    )
                ) {
                    AppNav(
                        exitApp = {
                            finish()
                        }
                    )
                }
            }
        }
    }

    @SuppressLint("WakelockTimeout")
    override fun onResume() {
        super.onResume()
        // 重新申请 WakeLock
        if (!wakeLock.isHeld) {
            wakeLock.acquire()
        }
    }

    override fun onPause() {
        super.onPause()
        // 释放 WakeLock
        if (wakeLock.isHeld) {
            wakeLock.release()
        }
    }

    override fun onDestroy() {
        if (isPhone) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
        super.onDestroy()
    }

    override fun restartApp() {
        val intent = Intent(this.application, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        this.application.startActivity(intent)
        finish()
    }

}

