package com.mykuyademo.network

import com.mykuyademo.models.News
import com.mykuyademo.models.Product
import retrofit2.http.GET


interface ServicesApi {

    @GET("/productlist")
    suspend fun getProductListAsync(): List<Product>

    @GET("/news")
    suspend fun getNews(): List<News>
}