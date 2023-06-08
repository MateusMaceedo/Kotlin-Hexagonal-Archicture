package com.arquitecture.poc.hexagonalarch.adapters.usecases.busca

import com.arquitecture.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class FindStudentByIdUseCaseIntegrationTest: BaseDatabaseIntegrationTest() {

    @Autowired
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseInterface

    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should find  a student by id`() {

        val studentToSave = StudentEntity("abc", "Student Test")
        studentPersistence.save(studentToSave)

        val savedStudent = findStudentByIdUseCase.findById("abc")

        Assertions.assertEquals(studentToSave, savedStudent)
    }
}