package io.github.davidmerrick.knotion.model.properties

import com.fasterxml.jackson.annotation.JsonInclude
import io.github.davidmerrick.knotion.model.properties.PropertyType.Checkbox

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CheckboxProperty(
    override val id: String? = null,
    val checkbox: Boolean
) : NotionProperty {
    override val type = Checkbox
}
