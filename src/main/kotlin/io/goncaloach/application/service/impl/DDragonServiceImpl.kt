package io.goncaloach.application.service.impl

import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import io.goncaloach.application.service.DDragonService
import io.goncaloach.interfaces.dto.DDragonChampionDto
import io.goncaloach.interfaces.rest.client.DDragonClient
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class DDragonServiceImpl : DDragonService {

    @RestClient
    private lateinit var ddragonClient: DDragonClient

    @ConfigProperty(name = "lol.current-patch")
    private lateinit var lolCurrentPatch: String

    override fun getChampionsList(): List<DDragonChampionDto> {
        val jsonString = ddragonClient.getChampionsInfo(lolCurrentPatch)
        val treeMapData = getTreeMapFromJsonString(jsonString)
        return createChampionDtosFromTreeMap(treeMapData).toList()
    }

    private fun getTreeMapFromJsonString(jsonString: String): LinkedTreeMap<*, *> {
        val gson = Gson()
        val type = object : TypeToken<HashMap<String, Any>>() {}.type
        val hashMap: HashMap<String, Any> = gson.fromJson(jsonString, type)
        return hashMap["data"] as LinkedTreeMap<*, *>
    }

    private fun createChampionDtosFromTreeMap(treeMapData: LinkedTreeMap<*, *>): MutableList<DDragonChampionDto> {
        val champions = mutableListOf<DDragonChampionDto>()
        for (championJson in treeMapData) {
            val championName = championJson.key as String
            val championData = championJson.value as LinkedTreeMap<*, *>
            val championId = (championData["key"] as String).toLong()
            val championRoles = championData["tags"] as ArrayList<String>
            champions.add(DDragonChampionDto(name = championName, id =  championId, roles = championRoles))
        }
        return champions
    }
}