package com.cric.ipl25.meme

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.crick.ipl25.R
import com.crick.ipl25.databinding.ActivityMemeAddBinding
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

public class memeAdd : AppCompatActivity() {

    private lateinit var storageReference: StorageReference
    private var db = FirebaseFirestore.getInstance()
    private var collectionReference: CollectionReference = db.collection("meme")
    private lateinit var imageUri: Uri
    private lateinit var binding: ActivityMemeAddBinding
    private var isButtonClicked = false

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_meme_add)
        binding.letBack.setOnClickListener {
            var i = Intent(this, meme::class.java)
            startActivity(i)
            finish()
        }

        storageReference = FirebaseStorage.getInstance().getReference()

        binding.apply {
            postBtn.setOnClickListener {
                if (!isButtonClicked) {
                    postBtn.isEnabled = false
                    isButtonClicked = true
                    saveJournal()
                }
            }

            postImageButton.setOnClickListener {
                val i = Intent(Intent.ACTION_GET_CONTENT)
                i.type = "image/*"
                startActivityForResult(i, 1)
            }
        }
    }

    private fun saveJournal() {

        binding.progressBar.visibility = View.VISIBLE
        val teamName: String = binding.teamName.text.toString().trim()
        val likes = 0
        val memeId = ""
        val liked = false
        val reportCount=0

        if (!TextUtils.isEmpty(teamName) && imageUri != null) {
            val filePath: StorageReference = storageReference
                .child("journal_images" + UUID.randomUUID().toString())

            filePath.putFile(imageUri)
                .addOnSuccessListener {
                    filePath.downloadUrl.addOnSuccessListener { uri ->
                        val imageUri: String = uri.toString()

                        val memeData = Meme_data(
                            memeId,
                            imageUri,
                            teamName,
                            likes,
                            liked,
                            reportCount
                        )

                        collectionReference.add(memeData)
                            .addOnSuccessListener {
                                // Hide the progress bar when upload is successful
                                binding.progressBar.visibility = View.GONE

                                val i = Intent(this, meme::class.java)
                                startActivity(i)
                                finish()
                            }
                            .addOnFailureListener {
                                // Hide the progress bar in case of failure
                                binding.progressBar.visibility = View.GONE
                                // Handle the failure
                            }
                    }
                }
                .addOnProgressListener { taskSnapshot ->
                    // Calculate the progress percentage
                    val progress =
                        (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount).toInt()

                    binding.progressBar.progress = progress
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                imageUri = data.data!!
                binding.postImage.setImageURI(imageUri)
            }
        }
    }
}
