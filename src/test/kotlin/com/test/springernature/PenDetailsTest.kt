package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import db.pens
import org.http4k.core.*
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK

import org.junit.jupiter.api.Test
import serverPen

class PenDetailsTest {

    @Test
    fun `Should fetch pen name using Id`() {

        val request = Request(Method.GET, "/").query("penId", "4")

        val expectedResponse = "Cello Pen"

        val actualResponse = serverPen(request)

        assertThat("status should be 200 OK success", actualResponse.status, equalTo(OK))
        assertThat("if found, should return name", actualResponse.bodyString(), equalTo(expectedResponse))

    }

    @Test
    fun `Should not fetch pen name when not found`() {

        val expected = ""
        val request = Request(Method.GET, "/").query("penId", "abc")

        val serverNew =
            { req: Request -> getPenDetails(req.query("penId"))?.let { Response(OK).body(it) } ?: Response(NOT_FOUND) }


        val actual = serverNew(request)


        assertThat("Status should be 404 Not Found", actual.status, equalTo(NOT_FOUND))
        assertThat("if not found, should not return name", actual.bodyString(), equalTo(expected))

    }

    private fun getPenDetails(id: String?): String? = pens[id?.toInt()]


    // Bad Request

}