package org.michaelbel.template.toast

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentToastBinding
import timber.log.Timber

/**
 * Android 11 Toast Updates: add callback.
 */
@AndroidEntryPoint
class ToastFragment: Fragment(R.layout.fragment_toast) {

    private var _binding: FragmentToastBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentToastBinding.bind(view)

        binding.toastButton.setOnClickListener {
            val toast = Toast.makeText(requireContext(), "Simple toast message", Toast.LENGTH_SHORT).also {
                it.setGravity(Gravity.CENTER, 0, 0)
                it.setMargin(0F, 0F)
            }

            if (Build.VERSION.SDK_INT >= 30) {
                toast.addCallback(object: Toast.Callback() {
                    override fun onToastShown() {
                        Timber.d("onToastShown")
                    }

                    override fun onToastHidden() {
                        Timber.d("onToastHidden")
                    }
                })
            }

            toast.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}