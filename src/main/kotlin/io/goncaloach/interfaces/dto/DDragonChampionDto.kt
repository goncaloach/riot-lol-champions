package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator

class DDragonChampionDto @JsonbCreator constructor (
        val name: String,
        val id: Long,
        val roles: List<String>
)
