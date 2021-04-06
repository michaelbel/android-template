package org.michaelbel.template.movie.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.michaelbel.template.Constants
import org.michaelbel.template.app.data.entity.MovieDb
import org.michaelbel.template.databinding.ItemMovieBinding
import java.util.*

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
        //notifyItemRangeInserted(0, movies.size)
    }

    class MovieViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieDb) {
            Picasso.get().load(String.format(Locale.US, Constants.TMDB_IMAGE, "w342", movie.posterPath)).into(binding.posterImageView)
            binding.titleTextView.text = movie.title
        }
    }
}