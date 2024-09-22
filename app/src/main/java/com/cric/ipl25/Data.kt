package com.cric.ipl25

data class Data(
    val bbbEnabled: Boolean,
    val date: String,
    val dateTimeGMT: String,
    val fantasyEnabled: Boolean,
    val hasSquad: Boolean,
    val id: String,
    val matchEnded: Boolean,
    val matchStarted: Boolean,
    val matchType: String,
    val matchWinner: String,
    val name: String,
    val score: List<Score>,
    val series_id: String,
    val status: String,
    val teamInfo: List<TeamInfo>,
    val teams: List<String>,
    val tossChoice: String,
    val tossWinner: String,
    val venue: String
)