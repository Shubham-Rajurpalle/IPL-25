package com.cric.ipl25.meme

data class Meme_data(

    var memeId:String="",
    var memeImage: String = "",
    var yourTeam: String = "Team Name",
    var likes: Int=0,
    var liked: Boolean=false,
    var reportCount: Int=0
) {

    constructor() : this("","", "Team Name", 0,false,0)
}
