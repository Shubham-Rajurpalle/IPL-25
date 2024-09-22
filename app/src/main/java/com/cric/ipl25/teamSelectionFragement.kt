package com.cric.ipl25

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cric.ipl25.chat.chatN
import com.crick.ipl25.databinding.FragmentTeamSelectionFragementBinding


class TeamSelectionFragment : Fragment() {

    private lateinit var binding: FragmentTeamSelectionFragementBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamSelectionFragementBinding.inflate(inflater, container, false)

        val teams = arrayOf(
            Team("Chennai Super Kings", "CSK"),
            Team("Royal Challengers Bangalore", "RCB"),
            Team("Mumbai Indians", "MI"),
            Team("Kolkata Knight Riders", "KKR"),
            Team("Rajasthan Royals", "RR"),
            Team("Punjab Kings", "PK"),
            Team("Delhi Capitals", "DC"),
            Team("Sunrisers Hyderabad", "SH"),
            Team("Lucknow Super Giants", "LSG"),
            Team("Gujarat Titans", "GT")
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, teams)
        binding.teamList.adapter = adapter

        binding.teamList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedTeam = adapter.getItem(position)
            selectedTeam?.let {
                saveTeamSelection(it.teamId, it.teamName)
                navigateToChatActivity(it.teamId, it.teamName)
            }
        }

        return binding.root
    }

    private fun saveTeamSelection(teamId: String, teamName: String) {
        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("teamId", teamId)
            putString("teamName", teamName)
            apply()
        }
    }

    private fun navigateToChatActivity(teamId: String, teamName: String) {
        val intent = Intent(requireContext(), chatN::class.java)
        intent.putExtra("teamId", teamId)
        intent.putExtra("teamName", teamName)
        startActivity(intent)
    }

    data class Team(val teamName: String, val teamId: String) {
        override fun toString(): String {
            return teamName
        }
    }
}
