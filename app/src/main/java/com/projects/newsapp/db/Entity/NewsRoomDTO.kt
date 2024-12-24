package com.projects.newsapp.db.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsRoomDTO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id : Int = 0,

    @ColumnInfo("imageSrc")
    val imageSrc: Int,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("subTitle")
    val subTitle : String,
)
