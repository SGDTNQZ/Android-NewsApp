package com.projects.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.projects.newsapp.db.Entity.NewsColumnRoomDTO
import com.projects.newsapp.db.Entity.NewsRowRoomDTO
import com.projects.newsapp.db.dao.NewsDao

@Database(entities = [NewsRowRoomDTO::class, NewsColumnRoomDTO::class], version = 2)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun getAccountDao(): NewsDao
}

object DatabaseHolder {

    private var _database: NewsDatabase? = null

    val database: NewsDatabase get() = _database!!

    fun getOrCreate(context: Context): NewsDatabase {
        if (_database == null) {
            _database = Room.databaseBuilder(
                context,
                NewsDatabase::class.java,
                "news-database",
            )
                .allowMainThreadQueries()
                .build()
        }

        return database
    }
}