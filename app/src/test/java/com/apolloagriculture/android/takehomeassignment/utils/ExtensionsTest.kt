package com.apolloagriculture.android.takehomeassignment.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExtensionsTest {

    @Test
    fun `splitCamelCase separates camel case string starting with lowercase`() {
        val test = "theBigBrownWolfJumped"
        val expected = "the Big Brown Wolf Jumped"

        assertThat(test.splitCamelCase()).isEqualTo(expected)
    }

    @Test
    fun `splitCamelCase separates camel case string starting with uppercase`() {
        val test = "TheBigBrownWolfJumped"
        val expected = "The Big Brown Wolf Jumped"

        assertThat(test.splitCamelCase()).isEqualTo(expected)
    }

}