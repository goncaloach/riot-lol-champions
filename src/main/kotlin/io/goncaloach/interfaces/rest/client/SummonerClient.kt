package io.goncaloach.interfaces.rest.client

import io.goncaloach.interfaces.dto.SummonerDto
import jakarta.ws.rs.GET
import jakarta.ws.rs.HeaderParam
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/lol/summoner/v4/summoners")
@RegisterRestClient(configKey="riot-summoner-api")
interface SummonerClient {

    @GET
    @Path("/by-name/{summonerName}")
    fun getSummonerByName(@PathParam("summonerName") summonerName: String,
                          @HeaderParam("X-Riot-Token") token: String
                          ): SummonerDto

}