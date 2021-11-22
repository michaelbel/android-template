package org.michaelbel.template.features.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import com.google.accompanist.insets.WindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.dialog.bottomsheet.CustomBottomSheetDialog
import org.michaelbel.template.features.dialog.model.DialogItem

@AndroidEntryPoint
class DialogsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets: WindowInsets = ViewWindowInsetObserver(this).start()
        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                DialogsScreen(::onNavigationBackClick, ::showDialog)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }

    private fun showDialog(dialog: DialogItem) {
        when (dialog) {
            DialogItem.BottomSheet -> {
                val bottomSheetDialog = CustomBottomSheetDialog()
                bottomSheetDialog.show(parentFragmentManager, "bottomSheet")
            }
            DialogItem.DatePicker -> {

            }
            DialogItem.TimePicker -> {

            }
        }
    }
}