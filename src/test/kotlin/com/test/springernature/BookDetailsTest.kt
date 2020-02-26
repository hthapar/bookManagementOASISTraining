package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Method
import org.http4k.core.Request
import org.junit.jupiter.api.Test
import server


class BookDetailsTest {

    @Test
    fun `Should fetch book name using book id`() {
        val request = Request(Method.GET, "/Book").query("bookId", "1")

        val expected = "Immortals of Meluha"

        val actual =  server(request)

        assertThat(actual.bodyString(), equalTo(expected))

    }
}