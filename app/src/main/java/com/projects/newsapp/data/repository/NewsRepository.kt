package com.projects.newsapp.data.repository

import com.projects.newsapp.data.api.NewsApi
import com.projects.newsapp.data.params.NewsParams

class NewsRepository(
    private val newsApi: NewsApi
) {

    suspend fun getNews(type: String) = newsApi.getNews(type)

    suspend fun getNewsById(
        type: String,
        id: Int
    ) = newsApi.getNewsById(
        type = type,
        id = id
    )

    suspend fun addNews(params: NewsParams) = newsApi.addNews(params)

}