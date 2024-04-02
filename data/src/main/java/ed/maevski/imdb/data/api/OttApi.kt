package ed.maevski.imdb.data.api

import ed.maevski.imdb.data.dto.movies.MovieAdditionalDetailsResponse
import ed.maevski.imdb.data.dto.movies.MovieData
import ed.maevski.imdb.data.dto.movies.MovieDetailsResponse
import ed.maevski.imdb.data.dto.movies.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OttApi {
    @GET("advancedsearch")
    suspend fun getAllMovies(
        @Query("start_year") start_year: Int,
        @Query("end_year") end_year: Int,
        @Query("min_imdb") min_imdb: Float,
        @Query("max_imdb") max_imdb: Float,
        @Query("genre") genre: String,
        @Query("language") language: String,
        @Query("type") type: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): MoviesResponse

    @GET("gettitleDetails")
    suspend fun getMovieDetailsById(
        @Query("imdbid") imdbid: String
    ): MovieData
//    ): MovieDetailsResponse

    @GET("getadditionalDetails")
    suspend fun getMovieAdditionalDetailsById(
        @Query("imdbid") imdbid: String
    ): MovieAdditionalDetailsResponse
//    ): MovieDetailsResponse
}