package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Rollup

data class RollupProperty(
    override val id: String? = null,
) : NotionProperty {
    override val type = Rollup
}
