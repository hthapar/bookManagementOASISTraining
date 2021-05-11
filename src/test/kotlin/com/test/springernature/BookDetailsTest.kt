package com.test.springernature

import BookDetails
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Method.*
import org.http4k.core.Request
import org.junit.jupiter.api.Test
import app
import db.BooksDB
import org.http4k.core.Status


class BookDetailsTest {
    val server = app()
    private val dao = BooksDB()

    @Test
    fun `Should fetch all books`() {
        val request = Request(GET, "/books")

        val expected = dao.getAllBooks().toString()

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should fetch all books2`() {
        val request = Request(GET, "/book/list")

        val expected = dao.getAllBooks().toString()

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should fetch book name using book id`() {
        val request = Request(GET, "/book").query("bookId", "1")

        val expected = "Immortals of Meluha"

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should fetch book name using book id from route param`() {
        val request = Request(GET, "/book/id/1")

        val expected = "Immortals of Meluha"

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should UPDATE book name using book id`() {
        val request = Request(PATCH, "/book/update/1").body(BookDetails("Test-Book",1).name)

        val expected = "BookName(name=Test-Book, id=1)"

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should DELETE book name using book id`() {
        val request = Request(DELETE, "/book/delete/1")

        val expected = Status.OK

        val actual =  server(request)

        assertThat(actual.status, equalTo(expected))

    }
}