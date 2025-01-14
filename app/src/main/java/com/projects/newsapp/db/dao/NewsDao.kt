package com.projects.newsapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.projects.newsapp.db.Entity.NewsColumnRoomDTO
import com.projects.newsapp.db.Entity.NewsRowRoomDTO

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsColumnRoomDTO")
    suspend fun getColumnNews(): List<NewsColumnRoomDTO>

    @Insert
    suspend fun insertColumnNews(newsRoomDTO: NewsColumnRoomDTO)


    @Query("SELECT * FROM NewsRowRoomDTO")
    suspend fun getRowNews(): List<NewsRowRoomDTO>

    @Insert
    suspend fun insertRowNews(newsRoomDTO: NewsRowRoomDTO)

    @Query("DELETE FROM NewsRowRoomDTO")
    suspend fun clearRowNews()

    @Query("DELETE FROM NewsColumnRoomDTO")
    suspend fun clearColumnNews()

}