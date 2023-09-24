package com.tscore.sports.multiviewmoviercv.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

import com.tscore.sports.multiviewmoviercv.core.iLoad

import com.tscore.sports.multiviewmoviercv.databinding.ItemDirectorBinding
import com.tscore.sports.multiviewmoviercv.databinding.ItemMovieBinding
import com.tscore.sports.multiviewmoviercv.databinding.ItemTitleBinding
import com.tscore.sports.multiviewmoviercv.models.HomeRCVItem

sealed class VH(val mainBinding: ViewBinding) : RecyclerView.ViewHolder(mainBinding.root) {

    class TitleVH(val binding: ItemTitleBinding) : VH(binding) {

        fun bind(data: HomeRCVItem.Title) {
            binding.textViewTitle.text = data.title

        }

    }

    class MovieVH(val binding: ItemMovieBinding) : VH(binding) {


        fun bind(data: HomeRCVItem.ResponseMoviesItem) {
            binding.imageViewMovie.iLoad(data.avatar)






        }

    }

    class DirectorVH(val binding: ItemDirectorBinding) : VH(binding) {

        fun bind(data: HomeRCVItem.ResponseDirectorItem) {
            binding.imageViewDirector.iLoad(data.avatar)
        }

    }


}