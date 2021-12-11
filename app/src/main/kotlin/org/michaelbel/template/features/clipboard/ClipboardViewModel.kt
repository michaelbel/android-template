package org.michaelbel.template.features.clipboard

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics

@HiltViewModel
class ClipboardViewModel @Inject constructor(
    private val clipboard: ClipboardManager
): ViewModel() {

    var clipText: CharSequence by mutableStateOf("")

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(ClipboardFragment::class.simpleName)
    }

    fun copyText() {
        val clip: ClipData = ClipData.newPlainText("simple text", "Hello, World!")
        clipboard.setPrimaryClip(clip)
    }

    fun pasteText() {
        if (!clipboard.hasPrimaryClip()) return

        val clipDescription: ClipDescription = clipboard.primaryClipDescription ?: return
        if (!clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) return

        val clip: ClipData.Item = clipboard.primaryClip?.getItemAt(0) ?: return

        viewModelScope.launch { clipText = clip.text }
    }

    fun clearClipboard() {
        if (Build.VERSION.SDK_INT >= 28) {
            clipboard.clearPrimaryClip()
        }
    }
}