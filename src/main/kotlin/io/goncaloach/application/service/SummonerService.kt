package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.SummonerDto

interface SummonerService {

    fun getSummoner(summonerName: String): SummonerDto

}