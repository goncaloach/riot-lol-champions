package io.goncaloach.application.service

import io.goncaloach.interfaces.dto.SummonerDTO

interface SummonerService {

    fun getSummoner(summonerName: String): SummonerDTO

}