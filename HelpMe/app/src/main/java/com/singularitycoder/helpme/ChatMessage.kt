package com.singularitycoder.helpme

import androidx.annotation.ColorRes

data class ChatMessage(
    val id: Long,
    val message: String,
    val chatItem: ChatItem,
    @ColorRes val chatTextColor: Int,
    @ColorRes val chatBackgroundColor: Int
)
