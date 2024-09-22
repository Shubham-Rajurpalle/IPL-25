package com.cric.ipl25.chat

data class ChatMessage(
    val messageId: String = "",
    val senderId: String = "",
    val senderName: String = "",
    val message: String = "",
    val timestamp: Long = 0L,
    val teamId: String = "",
    var reportCount: Int = 0
)
