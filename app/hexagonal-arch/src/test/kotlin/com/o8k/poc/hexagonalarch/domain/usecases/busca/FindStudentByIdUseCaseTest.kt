package com.o8k.poc.hexagonalarch.domain.usecases.busca

import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity
import com.o8k.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import com.o8k.poc.hexagonalarch.domain.usecases.busca.impl.FindStudentByIdUseCaseImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FindStudentByIdUseCaseTest {

    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseImpl

    @Test
    fun `should find a student by id`() {

        // arrange
        val student = StudentEntity("abc", "Student Test")

        Mockito.`when`(studentPersistence.findById("abc"))
            .then { student }

        // act
        val result = findStudentByIdUseCase.findById("abc")

        // assert
        Assertions.assertEquals(student, result)
    }
}