package com.mainduelo.calculator

import kotlin.math.sqrt

class Operator(var operator : CharSequence){

    public fun getResultOperator( firstNumber : Float, secondNumber : Float)
               : Float = when(operator){
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "÷" -> firstNumber / secondNumber
        "×" -> firstNumber * secondNumber
        else -> firstNumber
    }

    public fun getResultOperatorUnique(firstNumber: Float)
               : Float = when(operator){
        "x²" -> firstNumber * firstNumber
        "√"  -> sqrt(firstNumber)
        "%"  -> firstNumber / 100
        else -> firstNumber
    }
}