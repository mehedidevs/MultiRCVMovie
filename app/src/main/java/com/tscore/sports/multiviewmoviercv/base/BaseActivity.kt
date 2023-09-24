package com.tscore.sports.multiviewmoviercv.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint


abstract class BaseActivity<VB : ViewBinding>(

    private val inflateBinding: (inflater: LayoutInflater) -> VB


) : AppCompatActivity() {

    private var _binding: VB? = null


    val binding: VB
        get() = _binding as VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding.invoke(layoutInflater)
        setContentView(binding.root)


    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}