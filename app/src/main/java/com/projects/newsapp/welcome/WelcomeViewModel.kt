package com.projects.newsapp.welcome

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.data.params.NewsParams
import com.projects.newsapp.data.repository.NewsRepository
import com.projects.newsapp.db.Entity.NewsRoomDTO
import com.projects.newsapp.db.dao.NewsDao
import com.projects.newsapp.home.HomeActivity
import kotlinx.coroutines.launch
import kotlin.random.Random

class WelcomeViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    fun dispatch(
        event: WelcomeEvent,
        context: Context? = null
    ){
        when(event){
            is WelcomeEvent.OnClickToMain -> {
                viewModelScope.launch {
                    val result = newsRepository.addNews(NewsParams(1))
                    result.onSuccess {
                        println(it)
                        val intent = Intent(context, HomeActivity::class.java).apply {
                            putExtra(ARGS, event.args)
                        }
                        context?.startActivity(intent)
                    }
                        .onFailure {
                            println(it)

                        }
                }
            }
            WelcomeEvent.OnResume ->{

            }
        }
    }
}

