package com.example.imdb.data


data class Reviews(
    val username : String,
    val userUrl: String,
    val warningSpoilers: String,
    val date: String,
    val rate: String,
    val helpful: String,
    val title: String,
    val content: String
)


data class MovieReviews(val imDBId: String,
                        val title: String,
                        val fullTitle: String,
                        val type: String,
                        val year : String,
                        val items : List<Reviews>
)
