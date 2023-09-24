package com.tscore.sports.multiviewmoviercv.network

import com.tscore.sports.multiviewmoviercv.models.HomeRCVItem
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movies")
    suspend fun getMovies(): Response<List<HomeRCVItem.ResponseMoviesItem>>

    @GET("directors")
    suspend fun getDirector(): Response<List<HomeRCVItem.ResponseDirectorItem>>
}