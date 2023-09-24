package com.tscore.sports.multiviewmoviercv.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.tscore.sports.multiviewmoviercv.base.BaseActivity
import com.tscore.sports.multiviewmoviercv.databinding.ActivityMainBinding
import com.tscore.sports.multiviewmoviercv.models.HomeRCVItem
import com.tscore.sports.multiviewmoviercv.states.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }


    override fun onStart() {
        super.onStart()

        binding.recyclerView.adapter = adapter
        adapter.itemClick = { v, data, i ->
            val msg = when (data) {
                is HomeRCVItem.ResponseDirectorItem -> "Director"
                is HomeRCVItem.ResponseMoviesItem -> "Movie"
                is HomeRCVItem.Title -> "Title"
            }

            Log.d("TAG", "onStart: $msg")

            Toast.makeText(this, "msg",Toast.LENGTH_SHORT).show()


        }



        viewModel.homeData.observe(this) {
            when (it) {
                is UiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("TAG", "${it.message}")
                }

                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE

                    Log.d("TAG", "Loading..")
                }

                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("TAG", "${it.data.toString()}")


                    adapter.homeItems = it.data!!


                }
            }

        }
    }


}