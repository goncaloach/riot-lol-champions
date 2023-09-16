package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.ChampionDto
import io.goncaloach.interfaces.dto.ResultListResponseDto

interface ChampionService {

    fun getChampions(summonerName: String): ResultListResponseDto<ChampionDto>

}