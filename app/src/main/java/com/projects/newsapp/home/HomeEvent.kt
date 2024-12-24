package com.projects.newsapp.home

sealed interface HomeEvent {
    data class OnSearchTextChange(val text: String) : HomeEvent
    object OnAddClick : HomeEvent
    object OnLoading : HomeEvent
    object OnGetNews : HomeEvent

}