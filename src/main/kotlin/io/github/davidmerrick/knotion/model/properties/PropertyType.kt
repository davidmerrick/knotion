package io.github.davidmerrick.knotion.model.properties

object PropertyType {
    const val Rollup = "rollup"
    const val MultiSelect = "multi_select"
    const val Select = "select"
    const val Title = "title"
    const val CreatedTime = "created_time"
    const val RichText = "rich_text"
    const val Formula = "formula"
    const val Relation = "relation"
    const val Url = "url"
    const val Email = "email"
    const val PhoneNumber = "phone_number"
    const val Files = "files"
    const val Checkbox = "checkbox"

    // These are suffixed with type because they conflict with reserved Kotlin types
    const val DateType = "date"
    const val NumberType = "number"
}
