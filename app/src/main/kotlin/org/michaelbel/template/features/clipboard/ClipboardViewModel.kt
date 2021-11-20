package org.michaelbel.template.features.clipboard

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics

@HiltViewModel
class ClipboardViewModel @Inject constructor(
    analytics: Analytics,
    private val clipboard: ClipboardManager
): ViewModel() {

    val clipText = MutableSharedFlow<CharSequence>()

    init {
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

        viewModelScope.launch { clipText.emit(clip.text) }
    }

    fun clearClipboard() {
        if (Build.VERSION.SDK_INT >= 28) {
            clipboard.clearPrimaryClip()
        }
    }
}