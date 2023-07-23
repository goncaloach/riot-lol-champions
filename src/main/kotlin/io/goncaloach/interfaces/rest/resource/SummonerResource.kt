package io.goncaloach.interfaces.rest.resource

//import io.goncaloach.application.service.SummonerService
import io.goncaloach.application.service.SummonerService
import jakarta.annotation.Resource
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/summoner")
@Resource
class SummonerResource {

    @Inject
    private lateinit var summonerService: SummonerService

    @GET
    @Path("/{summonerName}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getSummonerInformation(@PathParam("summonerName") summonerName: String): Response {

        val summonerDto = summonerService.getSummoner(summonerName)
        return Response.ok(summonerDto).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    fun getSummonerInformation2(): Response {

        return Response.ok("lol").build()
    }
}