package com.cric.ipl25

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cric.ipl25.meme.Meme_data
import com.google.firebase.firestore.FirebaseFirestore

class MemeViewModel : ViewModel() {

    private val _memes = MutableLiveData<List<Meme_data>>()
    val memes: LiveData<List<Meme_data>> get() = _memes

    private val _error =MutableLiveData<String?>()
    var error:LiveData<String?> =_error

    private val firestore = FirebaseFirestore.getInstance()

    fun loadMemes() {
        firestore.collection("meme").get()
            .addOnSuccessListener { result ->
                val memeList = mutableListOf<Meme_data>()
                for (document in result) {
                    val meme = document.toObject(Meme_data::class.java)
                    meme.memeId = document.id
                    memeList.add(meme)
                }
                memeList.reverse()
                _memes.value = memeList
                _error.value=null
            }.addOnFailureListener {
                _error.value="Failed to load memes"
            }
    }

    fun updateLikesCount(memeId: String, likesCount: Int) {
        firestore.collection("meme").document(memeId).update("likes", likesCount)
    }

    fun deleteMeme(memeId: String) {
        firestore.collection("meme").document(memeId).delete()
    }

    fun reportMeme(memeId: String, reportCount: Int) {
        firestore.collection("meme").document(memeId).update("reportCount",reportCount)
    }

    interface MemeActionListener {
        fun showReportConfirmation(memeId: String,reportCount: Int)
    }

    var actionListener: MemeActionListener? = null

    fun reportConfirm(memeId: String,reportCount: Int) {
        actionListener?.showReportConfirmation(memeId,reportCount)
    }

}
