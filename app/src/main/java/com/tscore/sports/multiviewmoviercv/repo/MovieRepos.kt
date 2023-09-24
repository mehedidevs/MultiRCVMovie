package com.tscore.sports.multiviewmoviercv.repo

import com.tscore.sports.multiviewmoviercv.base.BaseRepo
import com.tscore.sports.multiviewmoviercv.network.MovieService
import javax.inject.Inject

class MovieRepos @Inject constructor(private val service: MovieService) : BaseRepo() {


    suspend fun getMovies() = safeApiCall { service.getMovies() }

    suspend fun getDirector() = safeApiCall { service.getDirector() }

}