package com.o8k.poc.hexagonalarch.domain.entities

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StudentEntityTest {

    // a classe precisa se auto validar
    @Test
    fun `should validate itself`() {
        // Arrange
        val student = StudentEntity("abc", "Student test")

        // Act and Assert
        Assertions.assertTrue(student.isValid())
    }

    @Test
    fun `should fail when not valid`() {
        // Arrange
        val student = StudentEntity("abc", "")

        // Act and Assert
        Assertions.assertFalse(student.isValid())
    }
}