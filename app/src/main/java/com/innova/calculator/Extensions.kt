package com.innova.calculator

import android.widget.EditText

fun EditText.formatToNumber(): Double {
    val text = this.text.toString()

    return if (text.isEmpty()) 0.0
    else text.toDouble()
}

infix fun Double.add(b:Double) = this + b

infix fun Double.subtraction(b:Double) = this - b

