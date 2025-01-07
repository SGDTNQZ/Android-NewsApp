package com.projects.newsapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.projects.newsapp.db.Entity.NewsRoomDTO

@Dao
interface NewsDao {
    @Query("SELECT * FROM NewsRoomDTO")
    suspend fun getNews() : List<NewsRoomDTO>

    @Insert
    suspend fun insertNews(newsRoomDTO: NewsRoomDTO)

    @Query("DELETE FROM NewsRoomDTO")
    suspend fun clearNews()
}