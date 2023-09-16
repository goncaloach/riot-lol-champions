package io.goncaloach.interfaces.dto

import jakarta.json.bind.annotation.JsonbCreator
import jakarta.json.bind.annotation.JsonbPropertyOrder

@JsonbPropertyOrder(value = ["totalCount", "results"])
class ResultListResponseDto<T> @JsonbCreator constructor(
    val results: List<T>,
    val totalCount: Int
)
