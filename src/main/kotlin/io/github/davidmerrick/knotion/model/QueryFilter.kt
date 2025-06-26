package io.github.davidmerrick.knotion.model

data class QueryFilter(
    val filter: Map<String, Any>? = null,
    val sorts: List<Map<String, Any>>? = null,
    val startCursor: String? = null,
    val pageSize: Int? = null
)
