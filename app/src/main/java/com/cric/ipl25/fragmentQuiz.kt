package com.cric.ipl25

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.crick.ipl25.R

import com.crick.ipl25.databinding.FragmentQuizBinding
import java.util.concurrent.TimeUnit

class FragmentQuiz(private val quizArray: question, private val questionId: Int) : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("quiz", Context.MODE_PRIVATE)

        // Set question and options
        binding.questiontxt.text = quizArray.question
        binding.option1.text = quizArray.o1
        binding.option2.text = quizArray.o2
        binding.option3.text = quizArray.o3
        binding.option4.text = quizArray.o4

        // Check if the question is answerable and enable/disable the RadioGroup accordingly
        if (isQuestionAnswerable(questionId)) {
            enableRadioGroup(true)
        } else {
            enableRadioGroup(false)
            restoreSelectedOption()
        }

        // Set listener for option selection
        binding.optionGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedOption = view.findViewById<RadioButton>(checkedId)
            selectedOption?.let {
                val isCorrect = it.text == quizArray.oc
                showToast(isCorrect)
                saveAnswer(selectedOption.text.toString())
                saveAnswerTimestamp(questionId)
                highlightCorrectAnswer()
                enableRadioGroup(false)
            }
        }

        return view
    }

    // Function to enable or disable all child views (RadioButtons) in the RadioGroup
    private fun enableRadioGroup(isEnabled: Boolean) {
        for (i in 0 until binding.optionGroup.childCount) {
            binding.optionGroup.getChildAt(i).isEnabled = isEnabled
        }
    }

    // Save the timestamp of when the question was answered
    private fun saveAnswerTimestamp(questionId: Int) {
        val editor = sharedPreferences.edit()
        editor.putLong("${questionId}_timestamp", System.currentTimeMillis())
        editor.apply()
    }

    // Save the selected answer in SharedPreferences
    private fun saveAnswer(selectedOption: String) {
        val editor = sharedPreferences.edit()
        editor.putString("${questionId}_selected_option", selectedOption)
        editor.apply()
    }

    // Check if the question is answerable (i.e., if 24 hours have passed since the last answer)
    private fun isQuestionAnswerable(questionId: Int): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastAnswerTime = sharedPreferences.getLong("${questionId}_timestamp", 0)
        return lastAnswerTime == 0L || currentTime - lastAnswerTime > TimeUnit.HOURS.toMillis(24)
    }

    // Restore the selected option from SharedPreferences and highlight the correct answer
    private fun restoreSelectedOption() {
        val selectedOption = sharedPreferences.getString("${questionId}_selected_option", null)
        selectedOption?.let {
            for (i in 0 until binding.optionGroup.childCount) {
                val radioButton = binding.optionGroup.getChildAt(i) as RadioButton
                if (radioButton.text == it) {
                    radioButton.isChecked = true
                    break
                }
            }
        }
        highlightCorrectAnswer()
    }

    // Highlight the correct answer by making it bold
    private fun highlightCorrectAnswer() {
        for (i in 0 until binding.optionGroup.childCount) {
            val radioButton = binding.optionGroup.getChildAt(i) as RadioButton
            if (radioButton.text == quizArray.oc) {
                radioButton.setTypeface(null, android.graphics.Typeface.BOLD)
                break
            }
        }
    }

    // Show a toast with animation indicating whether the selected answer is correct or wrong
    private fun showToast(isCorrect: Boolean) {
        val layout = LayoutInflater.from(requireContext()).inflate(R.layout.answer_wrong_right, null)
        val anime = layout.findViewById<LottieAnimationView>(
            if (isCorrect) R.id.correct_anime else R.id.wrong_anime
        )
        anime.visibility = View.VISIBLE
        anime.setAnimation(if (isCorrect) R.raw.correct_anime else R.raw.wrong_anime)
        anime.playAnimation()
        anime.loop(true)

        val toast = Toast(requireContext())
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.view = layout
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}
