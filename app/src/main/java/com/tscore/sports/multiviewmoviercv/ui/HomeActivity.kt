package com.tscore.sports.multiviewmoviercv.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tscore.sports.multiviewmoviercv.base.BaseActivity
import com.tscore.sports.multiviewmoviercv.databinding.ActivityMainBinding
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