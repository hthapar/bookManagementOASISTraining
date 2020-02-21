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

        val request = Request(GET, "/").query("id", "bookId")

        val server: HttpHandler = { _: Request -> Response(Status.OK).body("bookName") }

        val expected = "bookName"

        val actual =  server(request).bodyString()

        assertThat(actual, equalTo(expected))
    }
}