package io.github.davidmerrick.knotion.model

data class NotionPatch(
    val icon: Icon? = null,
    val properties: Map<String, Any>? = null
)
