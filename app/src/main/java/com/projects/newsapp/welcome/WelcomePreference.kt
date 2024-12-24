package com.projects.newsapp.welcome

import android.content.Context

class WelcomePreference (context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("welcome_pref", Context.MODE_PRIVATE)

    fun getTitle() = sharedPreferences.getString("title", "") ?: ""

    fun setTitle(title : String){
        sharedPreferences.edit().putString("title",title).apply()
    }

    fun getSubtitle() = sharedPreferences.getString("subTitle","") ?: ""

    fun setSubTitle(subTitle: String){
        sharedPreferences.edit().putString("subTitle", subTitle).apply()
    }
}