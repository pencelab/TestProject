package com.pencelab.testproject

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun shouldMultiply(){
        assertEquals(8, Utils.multiply(4, 2))
    }

    @Test
    fun shouldDivide(){
        assertEquals(4.0, Utils.divide(8, 2), .0)
    }

    @Test(expected = RuntimeException::class)
    fun shouldDivideByZeroThrowingException(){
        assertEquals(4.0, Utils.divide(8, 0), .0)
    }

    @Test
    fun shouldFail(){
        assertEquals(9, Utils.multiply(4, 2))
    }


}
