package com.example.mobileapp.domain.model

data class Tournament(
    val id:Int = 0,
    val Name:String = "",
    var tournamentTypeId:Int = 0,
    val tournamentTypeName: String = "",
    val players: List<Player> = listOf()
) {
}