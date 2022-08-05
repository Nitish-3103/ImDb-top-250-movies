package com.example.imdb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb.Adapter.MovieAdapter
import com.example.imdb.Adapter.MovieViewHolder
import com.example.imdb.data.MovieList
import com.example.imdb.data.Movies
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback as Callback


class MainActivity : AppCompatActivity() {
    private val movieInterface = MovieApi.retrofitService.getMovies()
    lateinit var adapter : MovieAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        recyclerView = findViewById(R.id.recycler_view)
        Log.e("on_create","recycler view found")
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        Log.e("layout manager",recyclerView.layoutManager.toString())
        }

    private fun getData(){
        movieInterface.enqueue(object : Callback<MovieList>{

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                val responseBody = response.body()!!
                Log.e(" on response",responseBody.toString())
                adapter = MovieAdapter(responseBody.items)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter


            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }


    }