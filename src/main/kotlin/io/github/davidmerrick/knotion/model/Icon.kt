package io.github.davidmerrick.knotion.model

data class Icon(
    val type: String?,
    val emoji: String?
) {
    companion object {
        fun fromEmoji(emoji: String) = Icon(type = "emoji", emoji = emoji)
    }
}
