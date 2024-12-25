@file:Suppress("unused", "ObsoleteSdkInt")

package org.michaelbel.core.ktx

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.net.toUri

fun Context.navigateToAppSetting() {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        "package:$packageName".toUri()
    ).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(intent)
}

fun Context.navigateToAppNotificationSettings() {
    val intent = Intent()
    when {
        Build.VERSION.SDK_INT >= 26 -> {
            intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        }
        else -> {
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", packageName)
            intent.putExtra("app_uid", applicationInfo.uid)
        }
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}

@Composable
fun rememberNavigateToAppSettings(): () -> Unit {
    val context = LocalContext.current
    val appSettingsContract = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        "package:${context.packageName}".toUri()
    ).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    return remember { { appSettingsContract.launch(intent) } }
}

@Composable
fun rememberNavigateToAppNotificationSettings(): () -> Unit {
    val context = LocalContext.current
    val appSettingsContract = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    val intent = Intent()
    when {
        Build.VERSION.SDK_INT >= 26 -> {
            intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
        }
        else -> {
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", context.packageName)
            intent.putExtra("app_uid", context.applicationInfo.uid)
        }
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    return remember { { appSettingsContract.launch(intent) } }
}

@Composable
fun rememberSpeechRecognitionLauncher(onInputText: (String) -> Unit): () -> Unit {
    val speechRecognizeContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        val data = activityResult.data
        val spokenText = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let { results ->
            results[0]
        }
        if (!spokenText.isNullOrEmpty()) {
            onInputText(spokenText)
        }
    }

    return {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        }
        speechRecognizeContract.launch(intent)
    }
}

@Composable
fun rememberRequestCameraPermission(
    onGranted: () -> Unit
): () -> Unit {
    val context = LocalContext.current
    val navigateToAppSettings = rememberNavigateToAppSettings()
    val cameraPermissionContract = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        val shouldRequest = (context as Activity).shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)
        when {
            granted -> onGranted()
            !granted && !shouldRequest -> navigateToAppSettings()
        }
    }
    return remember {
        {
            when {
                ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED -> {
                    cameraPermissionContract.launch(Manifest.permission.CAMERA)
                }
                else -> onGranted()
            }
        }
    }
}

@Composable
fun rememberRequestNotificationPermission(
    onGranted: () -> Unit
): () -> Unit {
    if (Build.VERSION.SDK_INT >= 33) {
        val context = LocalContext.current
        val navigateToAppSettings = rememberNavigateToAppSettings()
        val cameraPermissionContract = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            val shouldRequest = (context as Activity).shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)
            when {
                granted -> onGranted()
                !granted && !shouldRequest -> navigateToAppSettings()
            }
        }
        return remember {
            {
                when {
                    ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED -> {
                        cameraPermissionContract.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                    else -> onGranted()
                }
            }
        }
    } else {
        return {}
    }
}