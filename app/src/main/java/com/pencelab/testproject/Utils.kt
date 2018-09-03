package com.pencelab.testproject

object Utils {

    fun multiply(x: Int, y: Int) : Int = x * y

    fun divide(x: Int, y: Int) : Double{
        val result : Double
        when(y){
            0 -> throw RuntimeException("Division by 0 not supported in this universe.")
            else -> result = x.toDouble()/y.toDouble()
        }

        return result
    }

}