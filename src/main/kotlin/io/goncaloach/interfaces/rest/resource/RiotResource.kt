package io.goncaloach.interfaces.rest.resource

import io.goncaloach.application.service.RiotService
import jakarta.annotation.Resource
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/")
@Resource
class RiotResource {

    @Inject
    private lateinit var riotService: RiotService

    @GET
    @Path("/summoners/{summonerName}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getSummonerInformation(@PathParam("summonerName") summonerName: String): Response {
        val summonerDto = riotService.getSummoner(summonerName)
        return Response.ok(summonerDto).build()
    }

}