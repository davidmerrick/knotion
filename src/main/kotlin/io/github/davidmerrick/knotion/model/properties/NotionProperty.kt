package io.github.davidmerrick.knotion.model.properties

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.github.davidmerrick.knotion.model.properties.PropertyType.Checkbox
import io.github.davidmerrick.knotion.model.properties.PropertyType.CreatedTime
import io.github.davidmerrick.knotion.model.properties.PropertyType.DateType
import io.github.davidmerrick.knotion.model.properties.PropertyType.Email
import io.github.davidmerrick.knotion.model.properties.PropertyType.Files
import io.github.davidmerrick.knotion.model.properties.PropertyType.Formula
import io.github.davidmerrick.knotion.model.properties.PropertyType.MultiSelect
import io.github.davidmerrick.knotion.model.properties.PropertyType.NumberType
import io.github.davidmerrick.knotion.model.properties.PropertyType.PhoneNumber
import io.github.davidmerrick.knotion.model.properties.PropertyType.Relation
import io.github.davidmerrick.knotion.model.properties.PropertyType.RichText
import io.github.davidmerrick.knotion.model.properties.PropertyType.Rollup
import io.github.davidmerrick.knotion.model.properties.PropertyType.Select
import io.github.davidmerrick.knotion.model.properties.PropertyType.Title
import io.github.davidmerrick.knotion.model.properties.PropertyType.Url

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
)
@JsonSubTypes(
    value = [
        JsonSubTypes.Type(value = RelationProperty::class, name = Relation),
        JsonSubTypes.Type(value = DateProperty::class, name = DateType),
        JsonSubTypes.Type(value = MultiSelectProperty::class, name = MultiSelect),
        JsonSubTypes.Type(value = RichTextProperty::class, name = RichText),
        JsonSubTypes.Type(value = FormulaProperty::class, name = Formula),
        JsonSubTypes.Type(value = UrlProperty::class, name = Url),
        JsonSubTypes.Type(value = TitleProperty::class, name = Title),
        JsonSubTypes.Type(value = NumberProperty::class, name = NumberType),
        JsonSubTypes.Type(value = SelectProperty::class, name = Select),
        JsonSubTypes.Type(value = CreatedTimeProperty::class, name = CreatedTime),
        JsonSubTypes.Type(value = RollupProperty::class, name = Rollup),
        JsonSubTypes.Type(value = EmailProperty::class, name = Email),
        JsonSubTypes.Type(value = PhoneNumberProperty::class, name = PhoneNumber),
        JsonSubTypes.Type(value = FilesProperty::class, name = Files),
        JsonSubTypes.Type(value = CheckboxProperty::class, name = Checkbox)
    ]
)
interface NotionProperty {
    val id: String?
    val type: String
}
