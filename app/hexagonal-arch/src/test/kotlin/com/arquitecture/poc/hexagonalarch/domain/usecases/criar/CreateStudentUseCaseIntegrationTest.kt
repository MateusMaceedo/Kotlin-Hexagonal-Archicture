package com.arquitecture.poc.hexagonalarch.domain.usecases.criar

import com.arquitecture.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.input.CreateStudentUseCaseInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CreateStudentUseCaseIntegrationTest: BaseDatabaseIntegrationTest() {

    @Autowired
    lateinit var createStudentUseCase: CreateStudentUseCaseInterface

    @Test
    fun `should create a student`() {

        val studentToSave = StudentEntity("abc", "Student Test")

        val savedStudent = createStudentUseCase.save(studentToSave)

        Assertions.assertEquals(studentToSave, savedStudent)
    }
}