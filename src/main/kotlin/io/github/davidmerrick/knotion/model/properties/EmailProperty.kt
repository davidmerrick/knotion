package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Email

data class EmailProperty(
    override val id: String? = null,
    val email: String? = null
) : NotionProperty {
    override val type = Email
}
