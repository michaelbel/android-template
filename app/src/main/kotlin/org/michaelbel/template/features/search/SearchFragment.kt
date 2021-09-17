package org.michaelbel.template.features.search

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lapism.search.widget.MaterialSearchView
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSearchBinding
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragment_search) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentSearchBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(SearchFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBar.apply {
            setOnClickListener { requestFocusOnSearch() }
            setHint(getString(R.string.searchbar_hint))
            setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }

        binding.searchView.apply {
            setOnQueryTextListener(object: MaterialSearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: CharSequence): Boolean {
                    binding.queryTextView.text = newText
                    return true
                }

                override fun onQueryTextSubmit(query: CharSequence): Boolean {
                    return true
                }
            })
            setOnFocusChangeListener(object : MaterialSearchView.OnFocusChangeListener {
                override fun onFocusChange(hasFocus: Boolean) {}
            })
        }
    }

    private fun clearFocusOnSearch() {
        binding.searchView.clearFocus()
        binding.searchView.isGone = true
    }

    private fun requestFocusOnSearch() {
        binding.searchView.isVisible = true
        binding.searchView.requestFocus()
    }
}