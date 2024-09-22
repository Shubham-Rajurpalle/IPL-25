package com.cric.ipl25.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ChatViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val _messages = MutableLiveData<List<ChatMessage>>()
    val messages: LiveData<List<ChatMessage>> get() = _messages

    init {
        listenForMessages()
    }

    private fun listenForMessages() {
        firestore.collection("chats")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                firebaseFirestoreException?.let {
                    return@addSnapshotListener
                }

                querySnapshot?.let {
                    val messages = it.documents.mapNotNull { document ->
                        document.toObject(ChatMessage::class.java)
                    }
                    _messages.value = messages
                }
            }
    }

    fun sendMessage(message: ChatMessage) {
        firestore.collection("chats").add(message)
    }

    fun updateReportCount(chatId: String, reportCount: Int) {
        firestore.collection("chats").document(chatId).update("reportCount",reportCount)

        if(reportCount>=100){
            firestore.collection("chats").document(chatId).delete()
        }
    }

}
