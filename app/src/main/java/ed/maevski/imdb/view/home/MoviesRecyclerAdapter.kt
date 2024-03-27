package ed.maevski.imdb.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ed.maevski.ImdbTest.databinding.MovieCardBinding


class MoviesRecyclerAdapter() :
    RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>() {

    val TAG = "myLogs"

    inner class MovieViewHolder(binding: MovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val poster = binding.poster
        val title = binding.title
        val description = binding.description
        val itemContainer = binding.itemContainer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

    }
}
