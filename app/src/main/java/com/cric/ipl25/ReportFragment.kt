package com.cric.ipl25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.crick.ipl25.databinding.FragmentReportBinding

class reportFragment : DialogFragment() {

    private lateinit var binding: FragmentReportBinding
    private var memeId: String? = null
    private var reportCount:Int?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        memeId = arguments?.getString("memeId")
        reportCount=arguments?.getInt("reportCount")

        binding.confirmButton.setOnClickListener {
            (activity as? ConfirmationListener)?.onConfirmReport(memeId!!, reportCount!!)
            dismiss()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    interface ConfirmationListener {
        fun onConfirmReport(memeId: String,reportCount:Int)
    }
}
