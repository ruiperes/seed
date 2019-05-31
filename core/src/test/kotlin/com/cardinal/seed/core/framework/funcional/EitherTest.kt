package com.cardinal.seed.core.framework.funcional

import org.junit.Assert.*
import org.junit.Test

class EitherTest {

    @Test fun `Either Right should return correct type and value`(){
        // Arrange
        val message = "#Cardinal"

        // Act
        val result = Either.Right(message)

        // Assert
        assertTrue(result.isRight)
        assertFalse(result.isLeft)
        assertEquals(message, result.right)

        result.either({}, // Ignore Fail
            { right ->
                assertEquals(message, right)
            }
        )
    }

    @Test fun `Either Left should return correct type and value`(){
        // Arrange
        val message = "#Fail"

        // Act
        val result = Either.Left(message)

        // Assert
        assertTrue(result.isLeft)
        assertFalse(result.isRight)
        assertEquals(message, result.left)

        result.either({left -> assertEquals(message, left)},
            { } // ignore Right
        )
    }
}