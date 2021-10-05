package com.test.ilink.data.api

import com.test.ilink.data.model.DuckResponse
import io.reactivex.Single
import retrofit2.http.GET

interface DuckService {
    @GET("/api/random")
    fun getDuckData(): Single<DuckResponse>
}