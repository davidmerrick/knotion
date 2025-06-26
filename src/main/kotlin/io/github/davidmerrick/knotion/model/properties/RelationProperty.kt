package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Relation as RelationType

data class RelationProperty(
    override val id: String? = null,
    val hasMore: Boolean = false,
    val relation: List<NotionRelation> = listOf()
) : NotionProperty {
    override val type = RelationType

    companion object {
        fun from(id: String) = RelationProperty(relation = listOf(NotionRelation(id)))
    }
}
