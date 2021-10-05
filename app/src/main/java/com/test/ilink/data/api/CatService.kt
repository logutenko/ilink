package com.test.ilink.data.api

import com.test.ilink.data.model.CatResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CatService {
    @GET("catAPI/rest")
    fun getCatData(): Single<CatResponse>
}