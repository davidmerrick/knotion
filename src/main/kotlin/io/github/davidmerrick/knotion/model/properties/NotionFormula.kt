package io.github.davidmerrick.knotion.model.properties

data class NotionFormula(
    val type: String? = null,
    val string: String? = null,
    val date: NotionDate? = null,
    val boolean: Boolean? = null
)
