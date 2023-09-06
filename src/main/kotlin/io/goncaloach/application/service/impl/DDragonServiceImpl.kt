package io.goncaloach.application.service.impl

import io.goncaloach.application.service.DDragonService
import io.goncaloach.interfaces.rest.client.DDragonClient
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class DDragonServiceImpl: DDragonService {

    @RestClient
    private lateinit var ddragonClient: DDragonClient

    @ConfigProperty(name = "lol.current-patch")
    private lateinit var lolCurrentPatch: String

    override fun getChampionsList(): String {

        return ddragonClient.getChampionsInfo(lolCurrentPatch)
    }
}