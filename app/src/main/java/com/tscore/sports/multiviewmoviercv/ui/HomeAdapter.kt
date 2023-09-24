package com.tscore.sports.multiviewmoviercv.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tscore.sports.multiviewmoviercv.R
import com.tscore.sports.multiviewmoviercv.databinding.ItemDirectorBinding
import com.tscore.sports.multiviewmoviercv.databinding.ItemMovieBinding
import com.tscore.sports.multiviewmoviercv.databinding.ItemTitleBinding
import com.tscore.sports.multiviewmoviercv.models.HomeRCVItem

class HomeAdapter : RecyclerView.Adapter<VH>() {

    var homeItems = listOf<HomeRCVItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

     var itemClick: ((v: View, item: HomeRCVItem, position: Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return when (viewType) {

            R.layout.item_director -> VH.DirectorVH(
                ItemDirectorBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_movie -> VH.MovieVH(
                ItemMovieBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_title -> VH.TitleVH(
                ItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw Exception("Inavlid view Type")

        }


    }

    override fun getItemCount(): Int {
        return homeItems.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {



        when (holder) {
            is VH.DirectorVH -> holder.bind(homeItems[position] as HomeRCVItem.ResponseDirectorItem)
            is VH.MovieVH -> holder.bind(homeItems[position] as HomeRCVItem.ResponseMoviesItem)
            is VH.TitleVH -> holder.bind(homeItems[position] as HomeRCVItem.Title)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return when (homeItems[position]) {
            is HomeRCVItem.ResponseDirectorItem -> R.layout.item_director
            is HomeRCVItem.ResponseMoviesItem -> R.layout.item_movie
            is HomeRCVItem.Title -> R.layout.item_title
        }
    }


}