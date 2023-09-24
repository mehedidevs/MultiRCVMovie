package com.tscore.sports.multiviewmoviercv.core

import android.widget.ImageView
import coil.load
import com.tscore.sports.multiviewmoviercv.R

fun ImageView.iLoad(imageUrl: String?) {
    this.load(imageUrl) {
        crossfade(true)
        placeholder(R.drawable.placeholder)
        error(R.drawable.error)
        //transformations(CircleCropTransformation())
    }
}