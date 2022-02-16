package org.michaelbel.template.features.compose.clipboard

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics

@HiltViewModel
class ClipboardViewModel @Inject constructor(
    private val clipboard: ClipboardManager
): ViewModel() {

    private val _clipText: MutableStateFlow<String> = MutableStateFlow("")
    val clipText: StateFlow<String>
        get() = _clipText

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen("ClipboardScreen")
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

        viewModelScope.launch {
            _clipText.emit(clip.text.toString())
        }
    }

    fun clearClipboard() {
        if (Build.VERSION.SDK_INT >= 28) {
            clipboard.clearPrimaryClip()
        }
    }
}