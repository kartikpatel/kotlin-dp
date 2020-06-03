package com.kotlinbykartik.visitor

sealed class CarElement {
    open fun accept(visitor: Visitor<CarElement>) {
        visitor.visit(this)
    }
}

interface Visitor<T> {
    fun visit(element: T)
}

class Wheel(val name: String) : CarElement()
class Body : CarElement()
class Engine : CarElement()
class Car : CarElement() {
    private val elements: List<CarElement> = listOf(
        Wheel("front left"), Wheel("front right"),
        Wheel("back left"), Wheel("back right"),
        Body(), Engine()
    )

    override fun accept(visitor: Visitor<CarElement>) {
        for (element in elements) {
            element.accept(visitor)
        }
        visitor.visit(this)
    }
}

internal class CarElementDoVisitor : Visitor<CarElement> {
    override fun visit(element: CarElement) {
        when (element) {
            is Body -> println("Moving my body")
            is Car -> println("Starting my car")
            is Wheel -> println("Kicking my " + element.name + " wheel")
            is Engine -> println("Starting my engine")
        }
    }
}

internal class CarElementPrintVisitor : Visitor<CarElement> {
    override fun visit(element: CarElement) {
        when (element) {
            is Body -> println("Visiting body")
            is Car -> println("Visiting car")
            is Wheel -> println("Visiting " + element.name + " wheel")
            is Engine -> println("Starting my engine")
        }
    }
}