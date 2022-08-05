import com.example.imdb.data.MovieList
import com.example.imdb.data.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val MOVIE_URL = "https://imdb-api.com/en/API/"
val retrofit : Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(MOVIE_URL)
    .build()

interface MovieApiService {

    @GET("Top250Movies/k_zyx2hyxx")
    fun getMovies() : Call<MovieList>
}

object MovieApi{
    val retrofitService: MovieApiService = retrofit.create(MovieApiService::class.java)
}