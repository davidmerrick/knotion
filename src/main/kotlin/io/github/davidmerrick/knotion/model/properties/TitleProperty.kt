package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Title

data class TitleProperty(
    override val id: String? = null,
    val title: List<NotionText>? = null,
) : NotionProperty {
    override val type = Title
}
