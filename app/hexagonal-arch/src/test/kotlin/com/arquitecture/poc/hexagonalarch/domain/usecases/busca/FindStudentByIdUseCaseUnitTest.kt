package com.arquitecture.poc.hexagonalarch.domain.usecases.busca

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import com.arquitecture.poc.hexagonalarch.domain.usecases.busca.impl.FindStudentByIdUseCaseImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FindStudentByIdUseCaseUnitTest {

    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseImpl

    @Test
    fun `should find a student by id`() {

        val student = StudentEntity("abc", "Student Test")

        Mockito.`when`(studentPersistence.findById("abc"))
            .then { student }

        val result = findStudentByIdUseCase.findById("abc")

        Assertions.assertEquals(student, result)
    }
}