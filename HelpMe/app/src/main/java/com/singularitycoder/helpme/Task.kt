package com.singularitycoder.helpme

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Task(
    val id: Long,
    val name: String,
    val description: String,
    @DrawableRes val icon: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val nameColor: Int,
    @ColorRes val descriptionColor: Int,
    @ColorRes val iconColor: Int,
)
