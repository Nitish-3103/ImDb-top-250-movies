package com.example.imdb.data

import android.widget.RemoteViews


data class Movies(val id : String, val rank: String, val title : String, val fullTitle : String, val year: String, val image : String, val crew: String, val imDbRating: String,val imDbRatingCount: String )

data class MovieList(val items : List<Movies>)