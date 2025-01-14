package com.projects.newsapp.data.repository

import com.projects.newsapp.data.api.NewsApi
import com.projects.newsapp.data.entity.ItemDTO
import com.projects.newsapp.data.entity.NewsRowDTO
import com.projects.newsapp.data.entity.NewsType
import com.projects.newsapp.data.params.NewsParams
import com.projects.newsapp.db.Entity.NewsColumnRoomDTO
import com.projects.newsapp.db.Entity.NewsRowRoomDTO
import com.projects.newsapp.db.dao.NewsDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import java.util.Locale

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) {

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getNews(type: NewsType): Flow<NewsRowDTO> {
        return flow {
            val list = when (type) {
                NewsType.ROW -> newsDao.getRowNews().map {
                    ItemDTO(
                        id = it.id,
                        image = it.image,
                        title = it.title,
                        subTitle = it.subTitle
                    )
                }

                NewsType.COLUMN -> newsDao.getColumnNews().map {
                    ItemDTO(
                        id = it.id,
                        image = it.image,
                        title = it.title,
                        category = it.category,
                        author = it.author,
                        readTime = it.readTime
                    )
                }
            }
            emit(NewsRowDTO(list))
        }
            .flatMapConcat { roomDTO ->
                flow {
                    emit(roomDTO)
                    val response = newsApi.getNews(type.name.toLowerCase(Locale.getDefault()))
                    response.onSuccess { newsRowDTO ->
                        when (type) {
                            NewsType.ROW -> {
                                newsDao.clearRowNews()
                                newsRowDTO.itemDTOS.map {
                                    NewsRowRoomDTO(
                                        id = it.id,
                                        title = it.title,
                                        subTitle = it.subTitle.orEmpty(),
                                        image = it.image
                                    )
                                }.onEach {
                                    newsDao.insertRowNews(it)
                                }
                            }

                            NewsType.COLUMN -> {
                                newsDao.clearColumnNews()
                                newsRowDTO.itemDTOS.map {
                                    NewsColumnRoomDTO(
                                        id = it.id,
                                        title = it.title,
                                        image = it.image,
                                        category = it.category.orEmpty(),
                                        author = it.author.orEmpty(),
                                        readTime = it.readTime.orEmpty()
                                    )
                                }.onEach {
                                    newsDao.insertColumnNews(it)
                                }
                            }
                        }
                        emit(newsRowDTO)
                    }
                }
            }
    }


    suspend fun getNewsById(
        type: String,
        id: Int
    ) = newsApi.getNewsById(
        type = type,
        id = id
    )

    suspend fun addNews(params: NewsParams) = newsApi.addNews(params)

}