package com.example.movies

import android.content.Context
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.fragments.MainFrag
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies.fragments.MainFragDirections

class MovieAdapter(
    private val movieList: List<Movie>,
    var onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClick(movie)
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.movie_title)
        val description: TextView = itemView.findViewById(R.id.movie_description)
        val image: ImageView = itemView.findViewById(R.id.movie_image)

        fun bind(movie: Movie) {
            title.text = movie.title
            description.text = movie.description

            val resourceId = itemView.resources.getIdentifier(movie.imageUrl, "drawable", itemView.context.packageName)
            Glide.with(itemView)
                .load(resourceId)
                .into(image)
        }
    }
}
