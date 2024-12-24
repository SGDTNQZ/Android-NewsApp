package com.projects.newsapp.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.db.dao.NewsDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    lateinit var newsDao: NewsDao

    fun initDao(newsDao: NewsDao){
        this.newsDao = newsDao
    }

    var homeState = mutableStateOf(
        HomeState(
            searchText = "",
            columnData = UIState.OnLoading,
            rowData = emptyList()
        )
    )

    fun dispatch(event: HomeEvent){
        when(event){
            HomeEvent.OnAddClick ->{
            }
            is HomeEvent.OnSearchTextChange -> {
                homeState.value =
                    homeState.value.copy(searchText = event.text)
            }
            HomeEvent.OnLoading -> homeState.value =
                homeState.value.copy(columnData = UIState.OnLoading)

            HomeEvent.OnGetNews -> {
                viewModelScope.launch {
                    delay(3000L)
                    val newsRoomDTO = newsDao.getNews()
                    val newsUiList = newsRoomDTO.map {
                        NewsItem(
                            name = it.title
                        )
                    }
                    homeState.value.copy(columnData = UIState.OnGetNews(newsUiList))
                }
            }
        }
    }
}