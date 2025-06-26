package io.github.davidmerrick.knotion.model.properties

import com.fasterxml.jackson.databind.JsonNode
import io.github.davidmerrick.knotion.model.properties.PropertyType.MultiSelect

data class MultiSelectProperty(
    override val id: String? = null,

    // Todo: Model this
    val multiSelect: List<JsonNode>
) : NotionProperty {
    override val type = MultiSelect
}
