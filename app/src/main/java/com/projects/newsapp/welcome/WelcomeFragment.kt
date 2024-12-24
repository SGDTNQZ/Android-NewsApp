package com.projects.newsapp.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.projects.newsapp.db.DatabaseHolder
import com.projects.newsapp.extensions.viewModels

const val ARGS = "ACTION_ARGS"

class WelcomeFragment : Fragment(){

    private val welcomeViewModel : WelcomeViewModel by viewModels(
        viewModelInitializer = {
            WelcomeViewModel(
                newsDao = DatabaseHolder.getOrCreate(requireContext().applicationContext)
                    .getAccountDao()
            )
        }
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            WelcomeScreen(
                onEvent = {event -> welcomeViewModel.dispatch(event, requireContext()) }
            )
        }
    }

    override fun onResume() {
        super.onResume()
        welcomeViewModel.dispatch(WelcomeEvent.OnResume)
    }
}