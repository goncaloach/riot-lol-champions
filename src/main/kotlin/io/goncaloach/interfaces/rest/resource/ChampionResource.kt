package io.goncaloach.interfaces.rest.resource

import io.goncaloach.application.service.ChampionService
import io.goncaloach.application.service.DDragonService
import io.goncaloach.application.service.RiotService
import jakarta.annotation.Resource
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/")
@Resource
class ChampionResource {

    @Inject
    private lateinit var championService: ChampionService

    @GET
    @Path("/summoners/{summonerName}/champions")
    @Produces(MediaType.APPLICATION_JSON)
    fun getChampions(@PathParam("summonerName") summonerName: String): Response {
        val champions = championService.getChampions(summonerName)
        return Response.ok(champions).build()
    }

}