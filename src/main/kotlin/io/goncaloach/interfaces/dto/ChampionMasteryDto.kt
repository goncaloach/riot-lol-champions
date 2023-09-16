package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator

class ChampionMasteryDto @JsonbCreator constructor(
    val puuid: String,
    val championPointsUntilNextLevel: Long,
    val chestGranted: Boolean,
    val championId: Long,
    val lastPlayTime: Long,
    val championLevel: Int,
    val summonerId: String,
    val championPoints: Int,
    val championPointsSinceLastLevel: Long,
    val tokensEarned: Int
)
