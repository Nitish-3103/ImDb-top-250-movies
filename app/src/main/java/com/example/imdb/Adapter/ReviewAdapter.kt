package com.example.imdb.Adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb.R
import com.example.imdb.data.MovieReviews
import kotlin.math.min

class ReviewAdapter(private val items : MovieReviews) : RecyclerView.Adapter<ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_review_adapter,parent,false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.nameTv.text = items.items[position].title
        holder.nameTv.setTypeface(null,Typeface.BOLD)
        holder.reviewTv.text = "${items.items[position].content.substring(0,min(items.items[position].content.length,90))}..."
    }

    override fun getItemCount(): Int {
        return items.items.size
    }
}

class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     val nameTv : TextView
     val reviewTv : TextView

    init{
        nameTv = itemView.findViewById(R.id.name)
        reviewTv = itemView.findViewById(R.id.review)
    }
}
