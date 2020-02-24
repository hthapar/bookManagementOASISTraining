package com.test.springernature

import db.books
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Method
import org.http4k.core.Request
import org.junit.jupiter.api.Test
import server


class BookDetailsTest {

    @Test
    fun `Should fetch book name using book id`() {
        val request = Request(Method.GET, "/").query("id", "1")

        val expected = "Immortals of Meluha"

        val actual =  server(request).bodyString()

        assertThat(actual, equalTo(expected))

    }
}