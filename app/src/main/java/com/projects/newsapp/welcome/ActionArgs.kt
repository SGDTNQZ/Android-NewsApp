package com.projects.newsapp.welcome

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActionArgs(
    val text : String
) : Parcelable
