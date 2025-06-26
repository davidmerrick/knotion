package io.github.davidmerrick.knotion.model.properties

import io.github.davidmerrick.knotion.model.properties.PropertyType.Formula

data class FormulaProperty(
    override val id: String? = null,
    val formula: NotionFormula
) : NotionProperty {
    override val type = Formula
}
