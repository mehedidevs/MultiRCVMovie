package com.tscore.sports.multiviewmoviercv.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tscore.sports.multiviewmoviercv.databinding.ActivityMainBinding
import com.tscore.sports.multiviewmoviercv.states.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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