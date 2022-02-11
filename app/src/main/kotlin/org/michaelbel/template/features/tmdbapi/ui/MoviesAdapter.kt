package org.michaelbel.template.features.tmdbapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.michaelbel.template.app.data.entity.MovieDb
import org.michaelbel.template.databinding.ItemMovieBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val data: MutableList<MovieDb> = mutableListOf()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun submitData(movies: List<MovieDb>) {
        data.clear()
        data.addAll(movies)
        notifyDataSetChanged()
    }

    class MovieViewHolder(
        binding: ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieDb) {}
    }
}