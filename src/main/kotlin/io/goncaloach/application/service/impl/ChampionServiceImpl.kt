package io.goncaloach.application.service.impl

import io.goncaloach.application.service.ChampionService
import io.goncaloach.application.service.DDragonService
import io.goncaloach.application.service.RiotService
import io.goncaloach.interfaces.dto.ChampionDto
import io.goncaloach.interfaces.dto.ChampionMasteryDto
import io.goncaloach.interfaces.dto.DDragonChampionDto
import io.goncaloach.interfaces.dto.ResultListResponseDto
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.util.Date

private const val CHAMPION_MASTERY_START_POINTS = 0
private const val CHAMPION_MASTERY_MIN_LEVEL = 1
private const val CHAMPION_MASTERY_SECOND_LEVEL_POINTS = 1800L

@ApplicationScoped
class ChampionServiceImpl : ChampionService {

    @Inject
    private lateinit var riotService: RiotService

    @Inject
    private lateinit var ddragonService: DDragonService

    override fun getChampions(summonerName: String): ResultListResponseDto<ChampionDto> {

        val summonersChampionsMastery = riotService.getChampionsMastery(summonerName).associateBy { it.championId }
        val allChampionsList = ddragonService.getChampionsList()

        val championDtos = allChampionsList.stream()
            .map { champion -> combineChampionInfoWithMastery(champion, summonersChampionsMastery) }
            .toList()

        return ResultListResponseDto(results = championDtos, totalCount = championDtos.size)
    }

    private fun combineChampionInfoWithMastery(
        champion: DDragonChampionDto,
        summonersChampionsMastery: Map<Long, ChampionMasteryDto>
    ): ChampionDto {

        val championId = champion.id
        val championName = champion.name
        val championRoles = champion.roles

        val summonerChampionMastery = summonersChampionsMastery[championId]
        val chestGranted = summonerChampionMastery?.chestGranted ?: false
        val lastPlayTime = summonerChampionMastery?.lastPlayTime?.let { Date(it) }
        val level = summonerChampionMastery?.championLevel ?: CHAMPION_MASTERY_MIN_LEVEL
        val points = summonerChampionMastery?.championPoints ?: CHAMPION_MASTERY_START_POINTS
        val pointsUntilNextLevel =
            summonerChampionMastery?.championPointsUntilNextLevel ?: CHAMPION_MASTERY_SECOND_LEVEL_POINTS

        return ChampionDto(
            id = championId, name = championName, roles = championRoles,
            chestGranted = chestGranted, lastPlayTime = lastPlayTime, level = level, points = points,
            pointsUntilNextLevel = pointsUntilNextLevel
        )
    }

}