package ed.maevski.imdb.data.api

import ed.maevski.imdb.data.dto.movies.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OttApi {
    @GET("advancedsearch")
    fun getDoctorsByClinicId(
        @Path("TASK_NODE_ID") taskNodeId: String
    ): Call<MoviesResponse>
}