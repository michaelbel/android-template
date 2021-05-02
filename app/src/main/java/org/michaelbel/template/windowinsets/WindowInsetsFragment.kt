package org.michaelbel.template.windowinsets

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentWindowInsetsBinding

/**
 * Внедрить после релиза androidx.code 1.5.0
 */
@AndroidEntryPoint
class WindowInsetsFragment: Fragment(R.layout.fragment_window_insets) {

    private var _binding: FragmentWindowInsetsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWindowInsetsBinding.bind(view)

        binding.showStatusBarButton.setOnClickListener {
            view.doOnLayout {
                WindowInsetsControllerCompat(requireActivity().window, view)
                    .show(WindowInsetsCompat.Type.statusBars())

                /*if (Build.VERSION.SDK_INT >= 30) {
                    view.windowInsetsController?.show(WindowInsets.Type.statusBars())
                }*/
            }
        }
        binding.hideStatusBarButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, view)
                .hide(WindowInsetsCompat.Type.statusBars())

            /*if (Build.VERSION.SDK_INT >= 30) {
                view.windowInsetsController?.hide(WindowInsets.Type.statusBars())
            }*/
        }

        binding.showKeyboardButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, binding.root)
                .show(WindowInsetsCompat.Type.ime())

            /*if (Build.VERSION.SDK_INT >= 30) {
                view.windowInsetsController?.show(WindowInsets.Type.ime())
            }*/
        }
        binding.hideKeyboardButton.setOnClickListener {
            WindowInsetsControllerCompat(requireActivity().window, binding.root)
                .hide(WindowInsetsCompat.Type.ime())

            /*if (Build.VERSION.SDK_INT >= 30) {
                view.windowInsetsController?.hide(WindowInsets.Type.ime())
            }*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}