package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Select

data class SelectProperty(
    override val id: String? = null,
    val select: NotionSelect? = null
) : NotionProperty {
    override val type = Select
}
