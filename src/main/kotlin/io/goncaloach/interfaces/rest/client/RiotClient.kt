package io.goncaloach.interfaces.rest.client

import io.goncaloach.interfaces.dto.ChampionMasteryDto
import io.goncaloach.interfaces.dto.SummonerDto
import jakarta.ws.rs.GET
import jakarta.ws.rs.HeaderParam
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient(configKey = "riot-api")
interface RiotClient {

    @GET
    @Path("/lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerByName(
        @PathParam("summonerName") summonerName: String,
        @HeaderParam("X-Riot-Token") token: String
    ): SummonerDto

    @GET
    @Path("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}")
    fun getChampionsMastery(
        @PathParam("encryptedPUUID") puuid: String,
        @HeaderParam("X-Riot-Token") token: String
    ): List<ChampionMasteryDto>

}