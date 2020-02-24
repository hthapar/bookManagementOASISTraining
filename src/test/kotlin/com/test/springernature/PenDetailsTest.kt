package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import db.pens
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
    fun `Should give a Not Found status in Response`(){

        val request = Request(Method.GET, "/").query("penId", "10")

        val serverNotFound = { req: Request ->
                                                if (req.query("penId")?.toInt() ?: 0 <= pens.keys.max()!!){
                                                    Response(Status.OK)
                                                    .body("${getPenDetails(req.query("penId")?.toInt())}")
                                                }
                                                else {
                                                    Response(Status.NOT_FOUND)

                                                }
                                            }

        val expected = "404 Not Found"

        val actual = serverNotFound(request).status.toString()

        println(actual)

        assertThat(actual, equalTo(expected))

    }

    private fun getPenDetails(penId: Int?) = pens[penId] //returns name of the Pen

}