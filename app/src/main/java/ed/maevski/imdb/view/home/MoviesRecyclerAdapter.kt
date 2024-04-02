package ed.maevski.imdb.view.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ed.maevski.ImdbTest.R
import ed.maevski.ImdbTest.databinding.MovieCardBinding
import ed.maevski.imdb.domain.model.Movie


class MoviesRecyclerAdapter(private val onItemClick: (id: String) -> Unit) :
    RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>() {

    private var movies: MutableList<Movie> = mutableListOf()

    val TAG = "myLogs"

    inner class MovieViewHolder(binding: MovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val poster = binding.poster
        val title = binding.title
        val description = binding.description
        val itemContainer = binding.itemContainer
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
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

    override fun getItemCount(): Int  = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.title.text = movie.title
        holder.description.text = movie.description

        Glide.with(holder.itemContainer)
            .load(movie.poster)
//            .error(R.drawable.ic_menu)
            .centerCrop()
            .into(holder.poster)

        holder.itemContainer.setOnClickListener {

            onItemClick(movie.id)
        }
    }
}
