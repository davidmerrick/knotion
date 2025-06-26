package io.github.davidmerrick.knotion.client

class NotionClientTest {

    fun `Get a page`(){
        val client = NotionClient(
            apiKey = "foo",
            apiHost = "localhost"
        )

        // Todo: Spin up wiremock here

    }
}
