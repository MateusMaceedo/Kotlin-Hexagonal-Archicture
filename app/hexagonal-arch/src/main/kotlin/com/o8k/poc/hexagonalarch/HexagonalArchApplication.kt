package com.o8k.poc.hexagonalarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.o8k.poc.hexagonalarch"))
class HexagonalArchApplication

fun main(args: Array<String>) {
	runApplication<HexagonalArchApplication>(*args)
}
