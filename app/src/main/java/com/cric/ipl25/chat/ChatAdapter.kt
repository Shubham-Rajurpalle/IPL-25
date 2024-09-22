package com.cric.ipl25.chat

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R

class ChatAdapter(private val reportListener: ReportListener, private var messages: List<ChatMessage>)
    : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {



    fun setMessages(newMessages: List<ChatMessage>) {
        messages = newMessages.reversed()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = messages.size

    class ChatViewHolder(itemView: View, private val listener: ReportListener) : RecyclerView.ViewHolder(itemView) {
        private val teamNameTextView: TextView = itemView.findViewById(R.id.teamNameTextView)
        private val messageTextView: TextView = itemView.findViewById(R.id.message)
        private val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        private val cardView: CardView = itemView.findViewById(R.id.cardView)
        private val reportBtn: ImageView = itemView.findViewById(R.id.reportBtn)

        fun bind(chatMessage: ChatMessage) {
            teamNameTextView.text = chatMessage.teamId
            timeTextView.text = android.text.format.DateFormat.format("hh:mm a", chatMessage.timestamp)

            teamNameTextView.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.white))
            teamNameTextView.setShadowLayer(9.5f, -6f, 6f, ContextCompat.getColor(itemView.context, android.R.color.black))

            val spannableString = SpannableString(chatMessage.message)
            spannableString.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, chatMessage.message.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            messageTextView.text = spannableString
            messageTextView.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.white))
            messageTextView.setShadowLayer(6.5f, -4f, 4f, ContextCompat.getColor(itemView.context, android.R.color.black))

            val teamColor = getTeamColor(chatMessage.teamId)
            cardView.setCardBackgroundColor(teamColor)

            reportBtn.setOnClickListener {
                chatMessage.reportCount=chatMessage.reportCount+1
                listener.onReportConfirming(chatMessage.messageId,chatMessage.reportCount)
            }

        }

        private fun getTeamColor(teamId: String): Int {
            return when (teamId) {
                "CSK" -> ContextCompat.getColor(itemView.context, R.color.cskColor)
                "RCB" -> ContextCompat.getColor(itemView.context, R.color.rcbColor)
                "MI" -> ContextCompat.getColor(itemView.context, R.color.miColor)
                "KKR" -> ContextCompat.getColor(itemView.context, R.color.kkrColor)
                "RR" -> ContextCompat.getColor(itemView.context, R.color.rrColor)
                "PK" -> ContextCompat.getColor(itemView.context, R.color.pkColor)
                "DC" -> ContextCompat.getColor(itemView.context, R.color.dcColor)
                "SH" -> ContextCompat.getColor(itemView.context, R.color.shColor)
                "LSG" -> ContextCompat.getColor(itemView.context, R.color.lsgColor)
                "GT" -> ContextCompat.getColor(itemView.context, R.color.gtColor)
                else -> ContextCompat.getColor(itemView.context, R.color.defaultColor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view, reportListener)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    interface ReportListener {
        fun onReportConfirming(chatMessage: String, reportCount: Int)
    }
}
