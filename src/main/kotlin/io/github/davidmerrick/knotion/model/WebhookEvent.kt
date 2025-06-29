package io.github.davidmerrick.knotion.model

data class WebhookEvent(
    val data: WebhookData,
    val inTrash: Boolean,
    val lastEditedTime: String?
)

data class WebhookData(
    val id: String
)
