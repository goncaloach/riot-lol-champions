package io.goncaloach.application.service.impl

import io.goncaloach.application.service.RiotService
import io.goncaloach.interfaces.dto.ChampionMasteryDto
import io.goncaloach.interfaces.dto.SummonerDto
import io.goncaloach.interfaces.rest.client.RiotClient
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class RiotServiceImpl : RiotService {

    @RestClient
    private lateinit var riotClient: RiotClient

    @ConfigProperty(name = "development.api.key")
    private lateinit var token: String

    override fun getSummoner(summonerName: String): SummonerDto {
        return riotClient.getSummonerByName(summonerName, token)
    }

    override fun getChampionsMastery(summonerName: String): List<ChampionMasteryDto> {
        val puuid : String = getSummoner(summonerName).puuid
        return riotClient.getChampionsMastery(puuid, token)
    }

}