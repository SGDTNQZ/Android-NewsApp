package com.projects.newsapp.welcome

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.data.params.NewsParams
import com.projects.newsapp.data.repository.NewsRepository
import com.projects.newsapp.home.HomeActivity
import kotlinx.coroutines.launch

class WelcomeViewModel(
) : ViewModel() {

    fun dispatch(
        event: WelcomeEvent,
        context: Context? = null
    ) {
        when (event) {
            is WelcomeEvent.OnClickToMain -> {
                viewModelScope.launch {
//                    val result = newsRepository.addNews(NewsParams(1))
//                    result.onSuccess {
                    val intent = Intent(context, HomeActivity::class.java).apply {
                        putExtra(ARGS, event.args)
                    }
                    context?.startActivity(intent)
//                }
//                        .onFailure {
//                        }
            }
        }
        WelcomeEvent.OnResume ->{ }

        }
    }
}

