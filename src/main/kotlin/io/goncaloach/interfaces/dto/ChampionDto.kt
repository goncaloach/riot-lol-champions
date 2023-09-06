package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator
import jakarta.json.bind.annotation.JsonbPropertyOrder
import java.util.Date

@JsonbPropertyOrder(value = ["name", "id", "roles", "chestGranted", "lastPlayTime",
        "level", "points", "pointsUntilNextLevel"])
class ChampionDto @JsonbCreator constructor (
        val id: Long,
        val name: String,
        val roles: List<String>,
        val chestGranted: Boolean,
        val lastPlayTime: Date,
        val level: Int,
        val points: Int,
        val pointsUntilNextLevel: Long
)
