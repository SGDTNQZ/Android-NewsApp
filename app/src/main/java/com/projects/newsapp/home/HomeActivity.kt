package com.projects.newsapp.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.projects.newsapp.db.DatabaseHolder

class HomeActivity(): ComponentActivity(){
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            HomeScreen(
                onEvent = {event -> homeViewModel.dispatch(event)},
                state = homeViewModel.homeState.value
            )
        }
    }
    override fun onResume() {
        super.onResume()
        homeViewModel.dispatch(HomeEvent.OnGetNews)
    }

}