package com.example.mobileapp.domain.model

import java.io.Serializable

data class Tournament(
    val id:Int = 0,
    var name:String = "",
    var tournamentTypeId:Int = 0,
    var tournamentTypeName: String = "",
    val players: MutableList<Player> = mutableListOf(),
    var statusId: Int = 0,
<<<<<<< HEAD
    var status: String = ""
): Serializable
=======
    var status: String = "",
    var userId: Int = 0
) {
}
>>>>>>> 01c793a866417028f14dcb32f67e80731c821393
