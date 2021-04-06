package org.michaelbel.template.movie.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentMoviesBinding

@AndroidEntryPoint
class MovieFragment: Fragment(R.layout.fragment_movies) {

    private val viewModel: MovieViewModel by viewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMoviesBinding.bind(view)

        binding.recyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }

        viewLifecycleOwner.addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.items.collectLatest { moviesAdapter.submitData(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MovieFragment()
    }
}