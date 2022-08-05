package com.example.imdb.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdb.R
import com.example.imdb.data.Movies
import org.w3c.dom.Text

class MovieAdapter(private val movies : List<Movies>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        Log.e("adapter","on create")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_movie_adapter,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Log.e("adapter","on bind")
        holder.titleTv.text = movies[position].title
        holder.fullTitleTv.text = movies[position].fullTitle
        holder.ratingTv.text = "Rating: ${movies[position].imDbRating}"
        holder.releaseTv.text = "Released in: ${movies[position].year}"
        Glide
            .with(holder.itemView)
            .load(movies[position].image)
            .centerCrop()
            .into(holder.imageTv)
    }

    override fun getItemCount(): Int {
        Log.e("adapter","on count")
        return movies.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleTv : TextView
    val fullTitleTv : TextView
    val ratingTv : TextView
    val releaseTv : TextView
    val imageTv : ImageView

    init {
        titleTv = itemView.findViewById(R.id.title)
        fullTitleTv = itemView.findViewById(R.id.full_title)
        ratingTv = itemView.findViewById(R.id.rating)
        releaseTv = itemView.findViewById(R.id.release_date)
        imageTv = itemView.findViewById(R.id.image)
    }

}
