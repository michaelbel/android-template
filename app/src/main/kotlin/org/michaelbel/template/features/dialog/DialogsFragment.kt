package org.michaelbel.template.features.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.dialog.bottomsheet.CustomBottomSheetDialog
import org.michaelbel.template.features.dialog.model.DialogItem
import org.michaelbel.template.features.dialog.ui.DialogsScreen

@AndroidEntryPoint
class DialogsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
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
            else -> {}
        }
    }
}