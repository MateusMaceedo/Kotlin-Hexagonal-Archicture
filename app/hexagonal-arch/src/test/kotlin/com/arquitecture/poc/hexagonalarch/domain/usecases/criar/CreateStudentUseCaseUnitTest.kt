package com.arquitecture.poc.hexagonalarch.domain.usecases.criar

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.exceptions.InvalidStudentException
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import com.arquitecture.poc.hexagonalarch.domain.usecases.criar.impl.CreateStudentUseCaseImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateStudentUseCaseUnitTest {

    @Mock
    lateinit var studentePersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var createStudentUseCase: CreateStudentUseCaseImpl

    @Test
    fun `should save a student`() {

        val studentToSave = StudentEntity("abc","Student test")

        Mockito.`when`(studentePersistence.save(studentToSave)).then { studentToSave }

        val result = createStudentUseCase.save(studentToSave)

        Assertions.assertEquals(studentToSave, result)
    }

    @Test
    fun `should throw exception when student not valid`() {

        val studentToSave = StudentEntity("abc","")

        val exception =
            assertThrows<InvalidStudentException> { createStudentUseCase.save(studentToSave) }

        val expected = "Sorry, check the information provided. Invalid operation!"

        Assertions.assertEquals(expected, exception.message)
    }
}