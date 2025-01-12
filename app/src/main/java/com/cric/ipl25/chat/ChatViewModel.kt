package com.cric.ipl25.chat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val _messages = MutableLiveData<List<ChatMessage>>()
    val messages: LiveData<List<ChatMessage>> get() = _messages

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        listenForMessages()
    }

    private fun listenForMessages() {
        firestore.collection("chats")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { querySnapshot, error ->
                error?.let {
                    _error.postValue("Error loading messages: ${it.message}")
                    return@addSnapshotListener
                }

                querySnapshot?.let { snapshot ->
                    try {
                        val messages = snapshot.documents.mapNotNull { document ->
                            document.toObject(ChatMessage::class.java)?.copy(messageId = document.id)
                        }
                        _messages.postValue(messages)
                    } catch (e: Exception) {
                        _error.postValue("Error processing messages: ${e.message}")
                    }
                }
            }
    }

    fun sendMessage(message: ChatMessage) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("chats")
                    .add(message)
                    .addOnFailureListener { e ->
                        _error.postValue("Failed to send message: ${e.message}")
                    }
            } catch (e: Exception) {
                _error.postValue("Error sending message: ${e.message}")
            }
        }
    }

    fun updateReportCount(messageId: String, reportCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val docRef = firestore.collection("chats").document(messageId)
                firestore.runTransaction { transaction ->
                    transaction.update(docRef, "reportCount", reportCount)

                    // If report count >= 100, mark for deletion
                    if (reportCount >= 100) {
                        transaction.delete(docRef)
                    }
                }.addOnFailureListener { e ->
                    _error.postValue("Failed to update report count: ${e.message}")
                }
            } catch (e: Exception) {
                _error.postValue("Error updating report count: ${e.message}")
            }
        }
    }
}