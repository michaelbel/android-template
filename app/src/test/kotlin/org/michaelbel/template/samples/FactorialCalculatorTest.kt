package org.michaelbel.template.samples

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.rules.ExpectedException
import org.michaelbel.template.app.samples.FactorialCalculator

class FactorialCalculatorTest {

    private val expectedException = ExpectedException.none()

    @Test(expected = IllegalStateException::class)
    fun computeFactorial_withNegative_raiseException() {
        FactorialCalculator.computeFactorial(-1)
        expectedException.expect(IllegalStateException::class.java)
        expectedException.expectMessage("Factorial is not defined for negative numbers")
    }

    @Test
    fun computeFactorial_forZero() {
        assertEquals(1, FactorialCalculator.computeFactorial(0))
    }

    @Test
    fun computeFactorial_forFive() {
        assertEquals(120, FactorialCalculator.computeFactorial(5))
    }
}