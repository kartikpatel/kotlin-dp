package com.kotlinbykartik.visitor

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    println(App().greeting)

    val car = Car()
    car.accept(CarElementPrintVisitor())
    car.accept(CarElementDoVisitor())
}
