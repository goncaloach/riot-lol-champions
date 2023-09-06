package io.goncaloach.interfaces.rest.resource

import io.goncaloach.application.service.DDragonService
import jakarta.annotation.Resource
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/test")
@Resource
class TestResource {

    @Inject
    private lateinit var ddragonService: DDragonService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getSummonerInformation(): Response {

        val test = ddragonService.getChampionsList()
        return Response.ok(test).build()
    }

}