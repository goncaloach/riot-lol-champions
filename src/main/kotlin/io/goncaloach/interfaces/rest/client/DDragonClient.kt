package io.goncaloach.interfaces.rest.client

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/cdn")
@RegisterRestClient(configKey="ddragon")
interface DDragonClient {

    @GET
    @Path("/{currentPatch}.1/data/en_US/champion.json")
    fun getChampions(@PathParam("currentPatch") currentPatch: String): String

}