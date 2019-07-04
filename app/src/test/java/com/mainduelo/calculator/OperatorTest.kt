package com.mainduelo.calculator

import org.junit.Test
import org.junit.Assert.*

class OperatorTest {

    val PLUS_SIGN : String = "+"
    val MINUS_SIGN : String = "-"
    val SPLIT_SIGN : String = "÷"
    val MULTIPLICATION_SIGN : String = "×"
    val SQUARE_SIGN : String = "x²"
    val ROOT_SIGN : String = "√"
    val PERCENTAGE_SIGN : String = "%"

    @Test
    fun plusTest() {
        assertEquals(2f, Operator(PLUS_SIGN).getResultOperator(1f, 1f))
        assertEquals(0f, Operator(PLUS_SIGN).getResultOperator(1f, -1f))
        assertEquals(0f, Operator(PLUS_SIGN).getResultOperator(0f, 0f))
        assertEquals(-2f, Operator(PLUS_SIGN).getResultOperator(-1f, -1f))
    }

    @Test
    fun minusTest() {
        assertEquals(0f, Operator(MINUS_SIGN).getResultOperator(1f, 1f))
        assertEquals(2f, Operator(MINUS_SIGN).getResultOperator(1f, -1f))
        assertEquals(0f, Operator(MINUS_SIGN).getResultOperator(0f, 0f))
        assertEquals(0f, Operator(MINUS_SIGN).getResultOperator(-1f, -1f))
    }

    @Test
    fun splitTest() {
        assertEquals(1f, Operator(SPLIT_SIGN).getResultOperator(1f, 1f))
        assertEquals(-1f, Operator(SPLIT_SIGN).getResultOperator(1f, -1f))
        assertEquals(0.5f, Operator(SPLIT_SIGN).getResultOperator(2f, 4f))
        assertEquals(1f, Operator(SPLIT_SIGN).getResultOperator(-1f, -1f))
    }

    @Test
    fun multiplicationTest() {
        assertEquals(1f, Operator(MULTIPLICATION_SIGN).getResultOperator(1f, 1f))
        assertEquals(-1f, Operator(MULTIPLICATION_SIGN).getResultOperator(1f, -1f))
        assertEquals(8f, Operator(MULTIPLICATION_SIGN).getResultOperator(2f, 4f))
        assertEquals(1f, Operator(MULTIPLICATION_SIGN).getResultOperator(-1f, -1f))
    }

    @Test
    fun squareTest() {
        assertEquals(1f, Operator(SQUARE_SIGN).getResultOperatorUnique(1f))
        assertEquals(4f, Operator(SQUARE_SIGN).getResultOperatorUnique(2f))
        assertEquals(9f, Operator(SQUARE_SIGN).getResultOperatorUnique(3f))
        assertEquals(81f, Operator(SQUARE_SIGN).getResultOperatorUnique(9f))
    }

    @Test
    fun rootTest() {
        assertEquals(1f, Operator(ROOT_SIGN).getResultOperatorUnique(1f))
        assertEquals(2f, Operator(ROOT_SIGN).getResultOperatorUnique(4f))
        assertEquals(3f, Operator(ROOT_SIGN).getResultOperatorUnique(9f))
        assertEquals(9f, Operator(ROOT_SIGN).getResultOperatorUnique(81f))
    }

    @Test
    fun percentageTest() {
        assertEquals(1f, Operator(PERCENTAGE_SIGN).getResultOperatorUnique(100f))
        assertEquals(0.5f, Operator(PERCENTAGE_SIGN).getResultOperatorUnique(50f))
        assertEquals(0.25f, Operator(PERCENTAGE_SIGN).getResultOperatorUnique(25f))
        assertEquals(0.01f, Operator(PERCENTAGE_SIGN).getResultOperatorUnique(1f))
    }
}
