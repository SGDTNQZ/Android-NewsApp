package com.projects.newsapp.home

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.NetworkApi
import com.projects.newsapp.data.api.NewsApi
import com.projects.newsapp.data.entity.NewsType
import com.projects.newsapp.data.repository.NewsRepository
import com.projects.newsapp.db.DatabaseHolder
import com.projects.newsapp.db.dao.NewsDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    lateinit var repository: NewsRepository

    fun setContext(context: Context) {
        this.repository = NewsRepository(
            newsApi = NetworkApi().retrofit.create<NewsApi>(
                NewsApi::class.java
            ),
            newsDao = DatabaseHolder.getOrCreate(context).getAccountDao()
        )
    }

    var homeState = MutableStateFlow(
        HomeState(
            searchText = "",
            columnData = ColumnUIState.OnLoading,
            rowData = RowUIState.OnLoading
        )
    )

    fun dispatch(event: HomeEvent){
        when(event) {
            HomeEvent.OnAddClick -> {

            }

            is HomeEvent.OnSearchTextChange -> {
                homeState.value = homeState.value.copy(searchText = event.text)
            }

            HomeEvent.OnLoading -> homeState.value =
                homeState.value.copy(columnData = ColumnUIState.OnLoading)

            HomeEvent.OnGetNews -> {
                viewModelScope.launch {
                    repository.getNews(NewsType.ROW).collect {
                        homeState.value =
                            homeState.value.copy(rowData = RowUIState.OnGetNews(it.itemDTOS.map {
                                RowNewsItem(
                                    title = it.title,
                                    subTitle = it.subTitle.orEmpty(),
                                    imageSrc = it.image
                                )
                            }))
                    }
                    repository.getNews(NewsType.COLUMN).collect {
                        homeState.value =
                            homeState.value.copy(columnData = ColumnUIState.OnGetNews(it.itemDTOS.map {
                                ColumnNewsItem(
                                    title = it.title,
                                    category = it.category.orEmpty(),
                                    author = it.author.orEmpty(),
                                    readTime = it.readTime.orEmpty(),
                                    image = it.image,
                                )
                            }))
                    }
                }
            }
        }
    }
}