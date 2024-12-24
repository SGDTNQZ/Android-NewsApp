package com.projects.newsapp.homePageScreen

data class HomeState(
    val searchText: String,
    val rowData: List<NewsItem>,
    val  columnData: UIState
)

data class NewsItem(
    val name : String
)
interface UIState{
    val news: List<NewsItem>

    object OnLoading: UIState{
        override val news: List<NewsItem> = emptyList<NewsItem>()
    }

    data class OnGetNews(
        override val news: List<NewsItem>
    ) : UIState
}