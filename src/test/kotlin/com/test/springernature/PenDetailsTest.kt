package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.*

import org.junit.jupiter.api.Test
import serverPen

class PenDetailsTest {

    @Test
    fun `Should fetch pen name using Id`(){

        val request = Request(Method.GET, "/").query("penId", "4")

        val expected = "Cello Pen"

        val actual = serverPen(request).bodyString() //response

        assertThat(actual, equalTo(expected))

    }

    @Test
    fun `Should give a Not Found Error`(){

        val request = Request(Method.GET, "/").query("penId", "100")

        val server: HttpHandler = { _: Request -> Response(Status.NOT_FOUND) }

        val expected = "404 Not Found"

        val actual = "404 Not Found"

        assertThat(actual, equalTo(expected))

    }
}