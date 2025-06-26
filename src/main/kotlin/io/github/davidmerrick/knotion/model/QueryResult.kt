package io.github.davidmerrick.knotion.model

data class QueryResult(
    val hasMore: Boolean,
    val nextCursor: String?,
    val results: List<NotionPage>
)
