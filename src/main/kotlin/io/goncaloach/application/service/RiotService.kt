package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.ChampionMasteryDto
import io.goncaloach.interfaces.dto.SummonerDto

interface RiotService {

    fun getSummoner(summonerName: String): SummonerDto

    fun getChampionsMastery(summonerName: String): List<ChampionMasteryDto>

}