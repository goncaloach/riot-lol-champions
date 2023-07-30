package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator
import jakarta.json.bind.annotation.JsonbProperty

class SummonerDTO @JsonbCreator constructor (

        @JsonbProperty("accountId")
        val accountId: String,

        @JsonbProperty("profileIconId")
        val profileIconId: Int,

        @JsonbProperty("revisionDate")
        val revisionDate: Long,

        @JsonbProperty("name")
        val name: String,

        @JsonbProperty("id")
        val id: String,

        @JsonbProperty("puuid")
        val puuid: String,

        @JsonbProperty("summonerLevel")
        val summonerLevel: String
)
