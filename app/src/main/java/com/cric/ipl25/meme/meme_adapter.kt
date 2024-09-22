package com.cric.ipl25.meme
import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.crick.ipl25.databinding.MemeCardBinding


@GlideModule
class MyAppGlideModule : AppGlideModule()

class MemeAdapter(private val context: Context, private val memeList: List<Meme_data>) :
    RecyclerView.Adapter<MemeAdapter.ViewHolder>() {

    companion object {
        private const val PREF_LIKED_MEMES = "liked_memes"
    }

    private val likedMemeIds: MutableSet<String>

    init {
        val sharedPreferences = context.getSharedPreferences(PREF_LIKED_MEMES, Context.MODE_PRIVATE)
        likedMemeIds = sharedPreferences.getStringSet(PREF_LIKED_MEMES, HashSet()) ?: HashSet()
    }


    inner class ViewHolder(val binding: MemeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(memecurr: Meme_data){
            binding.memeCard=memecurr
        }

        init {

            binding.shareMeme.setOnClickListener {
                val memeImageUri = binding.memeCard?.memeImage
                if (!memeImageUri.isNullOrEmpty()) {
                    val shareData = Intent(Intent.ACTION_SEND)
                    shareData.type = "image/*"
                    shareData.putExtra(Intent.EXTRA_STREAM, Uri.parse(memeImageUri))
                    val chooser = Intent.createChooser(shareData, "Share Image")
                    if (shareData.resolveActivity(binding.root.context.packageManager) != null) {
                        binding.root.context.startActivity(chooser)
                    }
                }
            }

            binding.likeMeme.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedMeme = memeList[position]
                    val memeId = clickedMeme.memeId
                    if (likedMemeIds.contains(memeId)) {
                        if (clickedMeme.likes>0) {
                            clickedMeme.likes = (clickedMeme.likes ?: 0) - 1
                            likedMemeIds.remove(memeId)
                        }

                    } else {
                        clickedMeme.likes = (clickedMeme.likes ?: 0) + 1
                        likedMemeIds.add(memeId)
                    }
                    (context as? meme)?.viewModel?.updateLikesCount(memeId, clickedMeme.likes ?: 0)
                    saveLikedMemeIdsToSharedPreferences()
                    notifyItemChanged(position)
                }
            }

            binding.reportBtn.setOnClickListener {
                val clickedMeme=memeList[adapterPosition]
                val memeId=clickedMeme.memeId

                clickedMeme.reportCount=(clickedMeme.reportCount ?: 0)+1
                (context as? meme)?.viewModel?.reportConfirm(memeId,clickedMeme.reportCount ?: 0)

                if (clickedMeme.reportCount>=100){
                    (context as? meme)?.viewModel?.deleteMeme(memeId)
                }
            }
        }

        private fun saveLikedMemeIdsToSharedPreferences() {
            context.getSharedPreferences(PREF_LIKED_MEMES, Context.MODE_PRIVATE).edit {
                putStringSet(PREF_LIKED_MEMES, likedMemeIds)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MemeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = memeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var memecurr: Meme_data =memeList[position]
        holder.bind(memecurr)

        Glide.with(holder.itemView.context)
            .load(memeList[position].memeImage)
            .fitCenter()
            .error(R.drawable.ic_menu_report_image)
            .into(holder.binding.postimage)
    }
}
