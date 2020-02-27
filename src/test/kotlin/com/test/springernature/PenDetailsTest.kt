package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import db.pens
import org.http4k.core.*
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK

import org.junit.jupiter.api.Test
import server

class PenDetailsTest {

    @Test
    fun `Should fetch pen name using Id`() {

        val request = Request(Method.GET, "/pen").query("penId", "4")

        val expectedResponse = "Cello Pen"

        val actualResponse = server(request)

        assertThat("status should be 200 OK success", actualResponse.status, equalTo(OK))
        assertThat("if found, should return name", actualResponse.bodyString(), equalTo(expectedResponse))

    }

    @Test
    fun `Should not fetch pen name when not found`() {

        val expected = ""

        val request = Request(Method.GET, "/pen").query("penId", "100")


        val actual = server(request)


        assertThat("Status should be 404 Not Found", actual.status, equalTo(NOT_FOUND))
        assertThat("if not found, should not return name", actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should give Bad request, if Id is invalid`() {

        val expected = "ERROR : Please Enter a valid ID!"

        val request = Request(Method.GET, "/pen").query("penId", "abc")


        val actual = server(request)


        assertThat("Status should be 400 Bad Request", actual.status, equalTo(BAD_REQUEST))
        assertThat("if text in ID, should give a Bad Request message", actual.bodyString(), equalTo(expected))
    }

    @Test
    fun `Should fetch name of all available pens`() {

        val expected = pensTestData.values.map { it.name }.toString()


        val request = Request(Method.GET, "/db.getPens")


        val actual = server(request)


        assertThat("Should give List of db.getPens", actual.bodyString(), equalTo(expected))

    }

    @Test
    fun `Should filter pen name by ink color`() {

        val expected = pensTestData
            .values
            .map { it }
            .filter { it.color == "black" }
            .map { it.name }.toString()


        val request = Request(Method.GET, "/pen").query("inkColor", "black")

        val app = { req: Request ->
            Response(OK).body(getPenNameByColor(req.query("inkColor")))
        }

        val actual = app(request)

        assertThat(actual.bodyString(), equalTo(expected))
    }

    private fun getPenNameByColor(color: String?): String {
        return pens
            .values
            .map { it }
            .filter { it.color == color }
            .map { it.name }.toString()
    }


}

















