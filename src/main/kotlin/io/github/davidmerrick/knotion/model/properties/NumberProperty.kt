package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.NumberType as NumberType

data class NumberProperty(
    override val id: String? = null,
    val number: Long
) : NotionProperty {
    override val type = NumberType
}
