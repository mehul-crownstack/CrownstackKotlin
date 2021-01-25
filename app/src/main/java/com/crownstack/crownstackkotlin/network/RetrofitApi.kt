package com.crownstack.crownstackkotlin.network

import com.crownstack.crownstackkotlin.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {

    private lateinit var mAppService: Apis

    fun getServerCallObject(): Apis {
        val loggingInterface = HttpLoggingInterceptor()
        loggingInterface.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterface).protocols(
            arrayListOf(Protocol.HTTP_1_1)
        ).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
        mAppService = retrofit.create(Apis::class.java)
        return mAppService
    }

}