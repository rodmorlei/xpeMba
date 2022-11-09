package com.example.desafiomodulo2

import kotlin.math.sqrt

fun main() {
    println("Hello World")
    val x: Int = sum(2, 3)
    println("Valor Somado: $x" )
    val y: Int = valorQuadrado(9)
    println("Valor Quadrado: $y" )
    val z: Float = raizQuadrada(y.toFloat())
    println("Valor Quadrado: $z" )
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun valorQuadrado(a: Int): Int {
    return a * a
}

fun raizQuadrada(a: Float): Float {
    return sqrt(a)
}