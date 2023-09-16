package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator

class SummonerDto @JsonbCreator constructor(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: String
)
