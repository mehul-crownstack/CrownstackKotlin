package com.crownstack.crownstackkotlin.model.response

import com.crownstack.crownstackkotlin.model.bo.ArtistBO
import com.google.gson.annotations.SerializedName

class MusicListResponse {

    @SerializedName("results")
    val mArtistList: ArrayList<ArtistBO> ?= null

}