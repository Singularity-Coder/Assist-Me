package com.singularitycoder.helpme

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Assistant(
    val id: Long,
    val name: String,
    val description: String,
    @DrawableRes val icon: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val nameColor: Int,
    @ColorRes val descriptionColor: Int,
    @ColorRes val iconColor: Int,
    val aiModel: String,
    val temperature: Double = 0.0,
    val maxTokens: Int = 0,
    val topP: Double = 0.0,
    val frequencyPenalty: Double = 0.0,
    val presencePenalty: Double = 0.0,
    val stop: Array<String> = arrayOf()
)
