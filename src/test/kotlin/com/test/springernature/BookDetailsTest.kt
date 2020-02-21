package com.test.springernature

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class BookDetailsTest {

    @Test
    fun `Should fetch book details using book id`() {

        val expected = "bookName"

        val actual = serverCall()


        assertThat(actual, equalTo(expected))
    }

    private fun serverCall(): String? = null
}