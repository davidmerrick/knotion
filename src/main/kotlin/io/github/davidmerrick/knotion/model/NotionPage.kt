package io.github.davidmerrick.knotion.model

import io.github.davidmerrick.knotion.model.properties.NotionProperty
import io.github.davidmerrick.knotion.model.properties.ParentField

data class NotionPage(
    val id: String? = null,
    val parent: ParentField? = null,
    val cover: String? = null,
    val createdTime: String? = null,
    val lastEditedTime: String? = null,
    val icon: Icon? = null,
    val url: String? = null,
    val publicUrl: String? = null,
    val properties: Map<String, NotionProperty>,
    val archived: Boolean = false,
    val inTrash: Boolean = false
)
