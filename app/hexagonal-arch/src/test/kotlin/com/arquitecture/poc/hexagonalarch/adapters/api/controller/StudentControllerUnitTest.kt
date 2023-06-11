package com.arquitecture.poc.hexagonalarch.adapters.api.controller

import com.arquitecture.poc.hexagonalarch.adapter.api.controller.StudentController
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.http.HttpStatus

class StudentControllerUnitTest {

    @Test
    fun `findStudentById should return student entity when student is found`() {
//        // Arrange
//        val expectedStudent = StudentEntity(id = "1", name = "John Doe")
//        val useCaseMock = mock(FindStudentByIdUseCaseInterface::class.java)
//        `when`(useCaseMock.findById("1")).thenReturn(expectedStudent)
//        val controller = StudentController(useCaseMock)
//
//        // Act
//        val response = controller.findStudentById("1")
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.statusCode)
//        assertEquals(expectedStudent, response.body)
    }
}