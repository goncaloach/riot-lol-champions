package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.DDragonChampionDto

interface DDragonService {

    fun getChampionsList(): List<DDragonChampionDto>

}