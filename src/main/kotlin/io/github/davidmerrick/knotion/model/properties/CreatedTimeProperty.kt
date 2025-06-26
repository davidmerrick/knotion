package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.CreatedTime

data class CreatedTimeProperty(
    override val id: String? = null,
    val date: NotionDate? = null
) : NotionProperty {
    override val type: String = CreatedTime
}
