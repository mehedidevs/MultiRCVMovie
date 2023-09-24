package com.tscore.sports.multiviewmoviercv.models

import com.google.gson.annotations.SerializedName

sealed class HomeRCVItem {

    data class Title(val title: String, val id: Int) : HomeRCVItem()


     class ResponseDirectorItem(
        @SerializedName("avatar") val avatar: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("id") val id: String,
        @SerializedName("movie_count") val movieCount: String,
        @SerializedName("name") val name: String
    ) : HomeRCVItem()

     class ResponseMoviesItem(
        @SerializedName("avatar") val avatar: String,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("store_id") val storeId: String,
        @SerializedName("thumbnail") val thumbnail: String,
        @SerializedName("title") val title: String,
    ) : HomeRCVItem()


}