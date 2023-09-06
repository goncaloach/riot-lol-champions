package io.goncaloach.application.service.impl

import io.goncaloach.application.service.ChampionService
import io.goncaloach.application.service.DDragonService
import io.goncaloach.application.service.RiotService
import io.goncaloach.interfaces.dto.ChampionDto
import io.goncaloach.interfaces.dto.ResultListResponseDto
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.util.Date

@ApplicationScoped
class ChampionServiceImpl : ChampionService {

    @Inject
    private lateinit var riotService: RiotService

    @Inject
    private lateinit var ddragonService: DDragonService

    override fun getChampions(summonerName: String): ResultListResponseDto<ChampionDto> {

        val championsMastery = riotService.getChampionsMastery(summonerName)
        val championsInfo = ddragonService.getChampionsList().associateBy { it.id }

        //TODO invert order because it only returns the champions that the person has played
        val championDtos = championsMastery.stream()
            .map { champion ->
                val championId = champion.championId
                val championName = championsInfo[championId]!!.name
                val championRoles = championsInfo[championId]!!.roles
                ChampionDto(
                    id = championId, name = championName, roles = championRoles,
                    chestGranted = champion.chestGranted, lastPlayTime = Date(champion.lastPlayTime),
                    level = champion.championLevel, points = champion.championPoints,
                    pointsUntilNextLevel = champion.championPointsUntilNextLevel
                )
            }
            .toList()

        return ResultListResponseDto(results = championDtos, totalCount = championDtos.size)
    }

}