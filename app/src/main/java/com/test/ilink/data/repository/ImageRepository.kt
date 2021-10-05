package com.test.ilink.data.repository

import com.test.ilink.data.api.RetrofitService
import com.test.ilink.data.model.CatResponse
import com.test.ilink.data.model.DuckResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ImageRepository {
    fun fetchCatUrl(): Single<String> {
        return RetrofitService.getCatService()
            .getCatData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map(CatResponse::url)
    }

    fun fetchDuckUrl(): Single<String> {
        return RetrofitService.getDuckService()
            .getDuckData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map(DuckResponse::url)
    }
}