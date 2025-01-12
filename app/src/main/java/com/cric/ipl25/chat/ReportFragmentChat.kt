package com.cric.ipl25.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.crick.ipl25.databinding.FragmentReportChatBinding

class reportFragmentChat : DialogFragment() {

    private lateinit var binding: FragmentReportChatBinding
    private var messageId: String? = null
    private var reportCount: Int? = null
    private var listener: ReportConfirmationListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageId = arguments?.getString("ChatMessage")
        reportCount = arguments?.getInt("reportCount")

        binding.confirmButton.setOnClickListener {
            if (messageId != null && reportCount != null) {
                listener?.onReportConfirmed(messageId!!, reportCount!!)
                dismiss()
            }
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    interface ReportConfirmationListener {
        fun onReportConfirmed(messageId: String, reportCount: Int)
    }

    fun setReportConfirmationListener(listener: ReportConfirmationListener) {
        this.listener = listener
    }
}
