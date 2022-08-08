package com.example.imdb.Network


import com.example.imdb.data.MovieReviews
import com.example.imdb.id
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val MOVIE_URL = "https://imdb-api.com/en/API/Reviews/k_zyx2hyxx/"
val retrofit : Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(MOVIE_URL)
    .build()

interface MovieReviewApiService {

@GET("{id}")
fun getReviews(@Path("id") id:String) : Call<MovieReviews>

}

object ReviewApi{
    val retrofitService: MovieReviewApiService = retrofit.create(MovieReviewApiService::class.java)
}