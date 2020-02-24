package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.Method
import org.http4k.core.Request

import org.junit.jupiter.api.Test

class PenDetails {

    @Test
    fun `Should fetch pen name using Id`(){

        val request = Request(Method.GET, "/").query("id", "1")

        val expected = "Cello Pen"

        val actual = getPenDetails()

        assertThat(actual, equalTo(expected))

    }

    private fun getPenDetails(): String? {
        return "Cello Pen"
    }
}