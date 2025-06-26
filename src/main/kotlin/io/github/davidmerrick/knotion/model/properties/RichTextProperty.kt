package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.RichText

data class RichTextProperty(
    override val id: String? = null,
    val richText: List<NotionRichText>
) : NotionProperty {
    override val type = RichText
}
