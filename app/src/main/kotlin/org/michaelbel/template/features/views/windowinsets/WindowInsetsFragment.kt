package org.michaelbel.template.features.views.windowinsets

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.ktx.doOnApplyWindowInsets
import org.michaelbel.core.ktx.topPadding
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentWindowInsetsBinding

@AndroidEntryPoint
class WindowInsetsFragment: Fragment(R.layout.fragment_window_insets) {

    private val binding: FragmentWindowInsetsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appBarLayout.doOnApplyWindowInsets { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.topPadding = systemBars.top
            WindowInsetsCompat.CONSUMED
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.showStatusBarButton.setOnClickListener {
            view.doOnLayout {
                WindowInsetsControllerCompat(requireActivity().window, view)
                    .show(WindowInsetsCompat.Type.statusBars())
            }
        }
        binding.hideStatusBarButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, view)
                .hide(WindowInsetsCompat.Type.statusBars())
        }

        binding.showKeyboardButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, binding.root)
                .show(WindowInsetsCompat.Type.ime())
        }
        binding.hideKeyboardButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, binding.root)
                .hide(WindowInsetsCompat.Type.ime())
        }
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(this::class.simpleName)
    }
}