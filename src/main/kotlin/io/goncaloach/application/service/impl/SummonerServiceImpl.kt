package io.goncaloach.application.service.impl

import io.goncaloach.application.service.SummonerService
import io.goncaloach.interfaces.dto.SummonerDTO
import io.goncaloach.interfaces.rest.client.SummonerClient
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class SummonerServiceImpl : SummonerService {

    @RestClient
    private lateinit var summonerClient: SummonerClient

    @ConfigProperty(name = "development.api.key")
    private lateinit var token: String

    override fun getSummoner(summonerName: String): SummonerDTO {

        return summonerClient.getSummonerByName(summonerName, token)
    }

}