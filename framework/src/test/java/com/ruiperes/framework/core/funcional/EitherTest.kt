package com.ruiperes.framework.core.funcional

import org.junit.Assert.*
import org.junit.Test

class EitherTest {

    @Test
    fun `Either Right should return correct type`() {
        val result = Either.Right("Sarah Connor")

        assertTrue(result.isRight)
        assertFalse(result.isLeft)
        result.either({ fail() },
            { right ->
                assertTrue(right == "Sarah Connor")
            })
    }

    @Test
    fun `Either Left should return correct type`() {
        val result = Either.Left("Sarah Connor")

        assertTrue(result.isLeft)
        assertFalse(result.isRight)
        result.either({ left ->
            assertTrue(left == "Sarah Connor")
        }, { fail() })
    }
}
