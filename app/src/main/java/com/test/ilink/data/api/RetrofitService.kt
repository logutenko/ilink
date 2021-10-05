package com.test.ilink.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val CAT_BASE_URL = "https://thatcopy.pw/"
    private const val DUCK_BASE_URL = "https://random-d.uk/"
    private var catService: CatService? = null
    private var duckService: DuckService? = null

    fun getCatService(): CatService {
        if (catService == null) {
            catService = Retrofit.Builder()
                .baseUrl(CAT_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatService::class.java)
        }
        return catService!!
    }

    fun getDuckService(): DuckService {
        if (duckService == null) {
            duckService = Retrofit.Builder()
                .baseUrl(DUCK_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DuckService::class.java)
        }
        return duckService!!
    }
}