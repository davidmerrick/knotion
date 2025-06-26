package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Url

data class UrlProperty(
    override val id: String? = null,
) : NotionProperty {
    override val type = Url
}
