package com.projects.newsapp.data.api

import com.projects.newsapp.data.entity.ItemDTO
import com.projects.newsapp.data.entity.NewsRowDTO
import com.projects.newsapp.data.params.NewsParams
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("news")
    suspend fun getNews(
        @Query("type") type: String
    ): Result<NewsRowDTO>

    @GET("news/{id}")
    suspend fun getNewsById(
        @Query("type") type: String,
        @Path("id") id: Int
    ): Result<Any>

    @POST("news")
    suspend fun addNews(
        @Body params: NewsParams
    ): Result<ItemDTO>

}