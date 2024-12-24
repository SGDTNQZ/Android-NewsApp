package com.projects.newsapp.welcome

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.db.Entity.NewsRoomDTO
import com.projects.newsapp.db.dao.NewsDao
import com.projects.newsapp.home.HomeActivity
import kotlinx.coroutines.launch
import kotlin.random.Random

class WelcomeViewModel(
    newsDao: NewsDao,
) : ViewModel() {
    init {
        viewModelScope.launch {
            newsDao.clearNews()
            val random = Random(1000)
            for (i in 0..6){
                newsDao.insertNews(
                    NewsRoomDTO(
                        imageSrc = 12,
                        title = random.nextInt(1000).toString(),
                        subTitle = random.nextInt(1000).toString()
                    )
                )
            }

        }
    }

    fun dispatch(
        event: WelcomeEvent,
        context: Context? = null
    ){
        when(event){
            is WelcomeEvent.OnClickToMain -> {
                val intent = Intent(context, HomeActivity::class.java).apply {
                    putExtra(ARGS, event.args)
                }
                context?.startActivity(intent)
            }
            WelcomeEvent.OnResume ->{

            }
        }
    }
}

