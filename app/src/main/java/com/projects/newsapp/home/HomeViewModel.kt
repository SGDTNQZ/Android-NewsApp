package com.projects.newsapp.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.newsapp.NetworkApi
import com.projects.newsapp.data.api.NewsApi
import com.projects.newsapp.data.repository.NewsRepository
import com.projects.newsapp.db.dao.NewsDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    val repository = NewsRepository(
        newsApi = NetworkApi().retrofit.create<NewsApi>(
            NewsApi::class.java
        )
    )

    var homeState = mutableStateOf(
        HomeState(
            searchText = "",
            columnData = ColumnUIState.OnLoading,
            rowData = RowUIState.OnLoading
        )
    )

    fun dispatch(event: HomeEvent){
        viewModelScope.launch {
            val rowData = repository.getNews("row")
            rowData.onSuccess {
                homeState.value =
                    homeState.value.copy(rowData = RowUIState.OnGetNews(it.itemDTOS.map {
                        RowNewsItem(
                            title = it.title,
                            subTitle = it.subTitle.orEmpty(),
                            imageSrc = it.image
                        )
                    }))

            }
            val columnData = repository.getNews("column")
            columnData.onSuccess {
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