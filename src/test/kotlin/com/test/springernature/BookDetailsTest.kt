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
    fun `Should NOT fetch book name if book id is not valid from route param`() {
        val request = Request(GET, "/book/id/123")

        val expected = "404 Not Found"

        val actual =  server(request)

        assertThat("Status should be 404 Not Found", actual.body.toString(), equalTo(Status.NOT_FOUND.toString()))
        assertThat("if not found, should not return name", actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should UPDATE book name using book id`() {
        val request = Request(PATCH, "/book/update/1").body(BookDetails("Test-Book",1).name.toString())

        val expected = "true"

        val actual =  server(request)

        assertThat("status should be 200 OK success", actual.status, equalTo(Status.OK))
        assertThat(actual.body.toString(), equalTo(expected))

    }

    @Test
    fun `Should NOT UPDATE book name if book id does not exist`() {
        val request = Request(PATCH, "/book/update/123").body(BookDetails("Test-Book",123).name.toString())

        val expected = false //yet to return correct Response

        val actual =  server(request)

        assertThat("status should be 404 NOT found", actual.body.toString(), equalTo(expected.toString()))

    }

    @Test
    fun `Should DELETE book name using book id`() {
        val request = Request(DELETE, "/book/delete/1")

        val expected = "Book Deleted"

        val actual =  server(request)

        assertThat(actual.status, equalTo(Status.OK))
        assertThat(actual.body.toString(), equalTo(expected))

    }

    @Test
    fun `Should ADD book name using new book id`() {
        val request = Request(POST, "/book/add/6").body("New Book")

        val expected = "Book added"

        val actual =  server(request)

        assertThat(actual.body.toString(), equalTo(expected))

    }

    @Test
    fun `Should NOT ADD book name if book id already exist`() {
        val request = Request(POST, "/book/add/3").body("New Book")

        val expected = "Book id Already Exist!!"

        val actual =  server(request)

        assertThat(actual.body.toString(), equalTo(expected))
    }
}