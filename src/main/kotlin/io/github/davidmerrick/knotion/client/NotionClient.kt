package io.github.davidmerrick.knotion.client

import io.github.davidmerrick.knotion.model.Icon
import io.github.davidmerrick.knotion.model.NotionPage
import io.github.davidmerrick.knotion.model.NotionPatch
import io.github.davidmerrick.knotion.model.QueryFilter
import io.github.davidmerrick.knotion.model.QueryResult
import io.github.davidmerrick.knotion.model.properties.ParentField
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.jackson.JacksonConverter
import mu.KotlinLogging

private const val NotionHost = "api.notion.com"
private val log = KotlinLogging.logger {}

class NotionClient(
    private val apiKey: String,
    apiHost: String = NotionHost
) {
    private val baseUrl = "https://$apiHost/v1"

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            register(
                ContentType.Application.Json,
                JacksonConverter(NotionObjectMapper)
            )
        }
        install(Logging) {
            level = LogLevel.INFO
        }
        defaultRequest {
            header("Authorization", "Bearer $apiKey")
            header("Notion-Version", "2022-06-28")
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getPage(pageId: String): NotionPage {
        log.info { "Fetching page $pageId" }
        val response: HttpResponse = client.get("$baseUrl/pages/$pageId")
        return response.body()
    }

    suspend fun patchPage(pageId: String, payload: NotionPatch): NotionPage {
        val response: HttpResponse = client.patch("$baseUrl/pages/$pageId") {
            setBody(payload)
        }
        return response.body()
    }

    suspend fun createDatabaseItem(databaseId: String, payload: NotionPage) {
        createPage(
            payload.copy(
                parent = ParentField(databaseId = databaseId)
            )
        )
    }

    suspend fun createPage(payload: NotionPage) {
        client.post("$baseUrl/pages") {
            setBody(payload)
        }
    }

    suspend fun listPages(
        databaseId: String,
        filter: QueryFilter = QueryFilter()
    ): List<NotionPage> {
        return buildList {
            var cursor: String? = filter.startCursor
            while (true) {
                val queryResult = listPagesAsQueryResult(databaseId, filter.copy(startCursor = cursor))
                addAll(queryResult.results)
                if (!queryResult.hasMore) break
                cursor = queryResult.nextCursor
            }
        }
    }

    suspend fun listPagesAsQueryResult(
        databaseId: String,
        filter: QueryFilter = QueryFilter(),
    ): QueryResult {
        log.info { "Listing pages with cursor ${filter.startCursor} in database $databaseId" }

        val response: HttpResponse = client.post("$baseUrl/databases/$databaseId/query") {
            setBody(filter)
        }

        return response.body()
    }

    suspend fun setIcon(pageId: String, emoji: String) {
        val patch = NotionPatch(icon = Icon.fromEmoji(emoji))
        patchPage(pageId, patch)
    }
}
