package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import db.booksJson
import org.http4k.core.Method
import org.http4k.core.Method.*
import org.http4k.core.Request
import org.junit.jupiter.api.Test
import server


class BookDetailsTest {
    val server = server()

    @Test
    fun `Should fetch all books in json format`() {
        val request = Request(GET, "/books")

        val expected = booksJson.toPrettyString()

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should fetch book name using book id`() {
        val request = Request(GET, "/book").query("bookId", "1")

        val expected = "\"Immortals of Meluha\""

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should fetch book name using book id from route param`() {
        val request = Request(GET, "/book/getBook/1")

        val expected = "\"Immortals of Meluha\""

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should UPDATE book name using path param book id`() {
        val request = Request(PUT, "/book/update/1").body("New Book Name")

        val expected = "\"Immortals of Meluha\" will be updated to \"New Book Name\""

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }


}