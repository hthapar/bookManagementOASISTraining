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


}