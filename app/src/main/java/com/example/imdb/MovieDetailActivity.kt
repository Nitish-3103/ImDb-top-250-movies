package com.example.imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdb.Adapter.MovieAdapter
import com.example.imdb.Adapter.ReviewAdapter
import com.example.imdb.Network.MovieReviewApiService
import com.example.imdb.Network.ReviewApi
import com.example.imdb.data.MovieReviews
import com.google.android.material.appbar.AppBarLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val reviewInterface = ReviewApi.retrofitService
lateinit var adapter : ReviewAdapter
lateinit var recyclerView: RecyclerView
lateinit var movieTitle : TextView
lateinit var fullTitle : TextView
lateinit var year : TextView
lateinit var rating : TextView
lateinit var image : ImageView
lateinit var id : String

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movieTitle = findViewById(R.id.title)
        fullTitle = findViewById(R.id.full_title)
        year = findViewById(R.id.release_date)
        rating = findViewById(R.id.rating)
        image = findViewById(R.id.poster)
        val toolbar = supportActionBar
        val details : Bundle? = intent?.extras?.getBundle("details")
        id = details?.get("id").toString()
        val movieRating = details?.get("rating").toString()
        rating.text = "Rating: ${movieRating}"
        val imageUrl = details?.get("url").toString()
        Glide
            .with(this)
            .load(imageUrl)
            .centerCrop()
            .into(image)
        getData()
        toolbar!!.title = details?.get("title").toString()
        toolbar!!.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.review_recycler)
        recyclerView.hasFixedSize()
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    private fun getData(){
        reviewInterface.getReviews(id).enqueue(object : Callback<MovieReviews>{
            override fun onResponse(call: Call<MovieReviews>, response: Response<MovieReviews>) {
                val responseBody = response.body()!!
                adapter = ReviewAdapter(responseBody)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                movieTitle.text = responseBody.title
                fullTitle.text = responseBody.fullTitle
                year.text = "Released in: ${responseBody.year}"
            }

            override fun onFailure(call: Call<MovieReviews>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}