package io.goncaloach.interfaces.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class SummonerDTO(
        val accountId: String,
        val profileIconId: Int,
        val revisionDate: Long,
        val name: String,
        val id: String,
        val puuid: String,
        val summonerLevel: String
)
