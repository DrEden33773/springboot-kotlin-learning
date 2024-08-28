package org.ember.demo

import com.mybatisflex.kotlin.extensions.sql.eq
import org.ember.demo.entity.table.StudentTableDef.Companion.STUDENT
import org.ember.demo.service.StudentService
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
    val studentService = ctx.getBean(StudentService::class.java)
    studentService.queryChain()
        .select()
        .where(STUDENT.NAME eq "mizuki")
        .list()
        .println()
}

