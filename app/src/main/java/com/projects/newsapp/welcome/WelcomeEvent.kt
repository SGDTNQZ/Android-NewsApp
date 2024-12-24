package com.projects.newsapp.welcome

sealed interface WelcomeEvent{
    data class OnClickToMain(val args: ActionArgs) : WelcomeEvent

    object OnResume : WelcomeEvent
}