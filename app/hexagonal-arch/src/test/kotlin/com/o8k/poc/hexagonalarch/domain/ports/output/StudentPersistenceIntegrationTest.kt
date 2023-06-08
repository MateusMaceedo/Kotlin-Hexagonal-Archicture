package com.o8k.poc.hexagonalarch.domain.ports.output

import com.o8k.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class StudentPersistenceIntegrationTest: BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should persist a student`() {
        // Arrange
        val studentToSave = StudentEntity("abc", "Student Test")

        // Act
        val savedStudent = studentPersistence.save(studentToSave)

        // Assert
        assertEquals(studentToSave, savedStudent)
    }

    @Test
    fun `should find a student by id`() {

        val studentToSave = StudentEntity("abc", "Student Test")
        studentPersistence.save(studentToSave)

        val studentFound = studentPersistence.findById("abc")

        assertEquals(studentToSave, studentFound)
    }
}