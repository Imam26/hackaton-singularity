package com.example.mobileapp.domain.model

import java.io.Serializable

data class Tournament(
    val id:Int = 0,
    var name:String = "",
    var tournamentTypeId:Int = 0,
    var tournamentTypeName: String = "",
    val players: MutableList<Player> = mutableListOf(),
    var statusId: Int = 0,
    var status: String = ""
): Serializable