package org.michaelbel.template.features.tmdbapi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentMoviesBinding

@AndroidEntryPoint
class MovieFragment: Fragment(R.layout.fragment_movies) {

    private val binding: FragmentMoviesBinding by viewBinding()

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }
}