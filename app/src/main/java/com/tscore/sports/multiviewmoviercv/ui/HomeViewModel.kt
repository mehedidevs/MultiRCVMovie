package com.tscore.sports.multiviewmoviercv.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tscore.sports.multiviewmoviercv.models.HomeRCVItem
import com.tscore.sports.multiviewmoviercv.repo.MovieRepos
import com.tscore.sports.multiviewmoviercv.states.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var repos: MovieRepos) : ViewModel() {

    private val _homeData = MutableLiveData<UiState<List<HomeRCVItem>>>()
    val homeData: LiveData<UiState<List<HomeRCVItem>>>
        get() = _homeData

    init {
        getHomeItems()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getHomeItems() {
        _homeData.postValue(UiState.Loading())
        val homeItemsList = mutableListOf<HomeRCVItem>()
        viewModelScope.launch {


            try {

                val moviesDeferred = async { repos.getMovies().data?.body() }
                val directorDeferred = async { repos.getDirector().data?.body() }

                val movies = moviesDeferred.await()
                val directors = directorDeferred.await()


                if (movies?.isNotEmpty() == true && directors?.isNotEmpty() == true) {
                    homeItemsList.add(HomeRCVItem.Title(id = 1, title = "Recommended"))
                    homeItemsList.addAll(movies)
                    homeItemsList.add(HomeRCVItem.Title(id = 2, title = "Director"))
                    homeItemsList.addAll(directors)
                    _homeData.postValue(UiState.Success(homeItemsList))
                } else {
                    _homeData.postValue(UiState.Error("No Data Found", false))
                }

            } catch (e: Exception) {
                _homeData.postValue(UiState.Error(e.message, true))
            }


        }


    }


}