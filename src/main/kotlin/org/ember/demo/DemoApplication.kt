package org.ember.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun <T> List<T>.println() {
    println("[")
    this.forEach { println("\t$it,") }
    println("]")
}

fun main(args: Array<String>) {
    val ctx = runApplication<DemoApplication>(*args)
}

