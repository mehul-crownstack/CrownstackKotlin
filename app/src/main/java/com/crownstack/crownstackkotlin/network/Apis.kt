package com.crownstack.crownstackkotlin.network

import com.crownstack.crownstackkotlin.model.response.MusicListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("search")
    fun getMusicList(@Query("term") musicianName:String) : Call<MusicListResponse>

}