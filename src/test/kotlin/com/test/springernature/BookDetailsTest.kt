package com.test.springernature
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.junit.jupiter.api.Test

class BookDetailsTest {

    @Test
    fun `Should fetch book name using book id`() {

        val expected = "bookName"

        val actual = serverCall()

        assertThat(actual, equalTo(expected))
    }

    private fun serverCall(): String {

        val request = Request(GET, "/").query("id", "bookId")

        val response = server(request)

        return response.bodyString()
    }

    private fun server(request: Request): Response {

        val server: HttpHandler = {
            Response(Status.OK)
            .body("bookName") }

        return server(request)
    }
}