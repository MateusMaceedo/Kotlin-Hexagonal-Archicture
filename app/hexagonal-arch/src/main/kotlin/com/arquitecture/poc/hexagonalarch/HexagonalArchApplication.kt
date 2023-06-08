package com.arquitecture.poc.hexagonalarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.arquitecture.poc.hexagonalarch"))
class HexagonalArchApplication

fun main(args: Array<String>) {
	runApplication<HexagonalArchApplication>(*args)
}
