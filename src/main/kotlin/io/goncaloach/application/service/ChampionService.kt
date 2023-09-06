package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.ChampionDto
import io.goncaloach.interfaces.dto.ChampionMasteryDto
import io.goncaloach.interfaces.dto.ResultListResponseDto
import io.goncaloach.interfaces.dto.SummonerDto
import io.goncaloach.interfaces.rest.client.RiotClient
import jakarta.inject.Inject
import org.eclipse.microprofile.rest.client.inject.RestClient


interface ChampionService {

    fun getChampions(summonerName: String): ResultListResponseDto<ChampionDto>

}