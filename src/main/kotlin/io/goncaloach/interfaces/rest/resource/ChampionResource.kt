package io.goncaloach.interfaces.rest.resource

import io.goncaloach.application.service.ChampionService
import jakarta.annotation.Resource
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
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
    fun getChampionsMastery(@PathParam("summonerName") summonerName: String): Response {
        val champions = championService.getChampions(summonerName)
        return Response.ok(champions).build()
    }

}