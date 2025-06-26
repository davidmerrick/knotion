package io.github.davidmerrick.knotion.model.properties

import com.fasterxml.jackson.annotation.JsonInclude
import io.github.davidmerrick.knotion.model.properties.PropertyType.DateType

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DateProperty(
    override val id: String? = null,
    val date: NotionDate? = null
) : NotionProperty {
    override val type = DateType
}
