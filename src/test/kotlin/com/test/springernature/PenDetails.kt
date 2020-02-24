package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo

import org.junit.jupiter.api.Test

class PenDetails {

    @Test
    fun `Should fetch pen name using Id`(){

        val expected = "Cello Pens"

        val actual = null

        assertThat(actual, equalTo(expected))

    }
}