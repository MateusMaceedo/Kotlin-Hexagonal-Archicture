package com.arquitecture.poc.hexagonalarch.domain.usecases.criar

import com.arquitecture.poc.hexagonalarch.domain.usecases.criar.impl.CreateStudenteUseCaseImpl
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateStudenteUseCaseUnitTest {

    @Mock
    lateinit var studentePersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var createStudentUseCase: CreateStudenteUseCaseImpl

    @Test
    fun `should save a student`() {

        val studentToSave = StudentEntity("abc","Student test")

        Mockito.`when`(studentePersistence.save(studentToSave)).then { studentToSave }

        val result = createStudentUseCase.save(studentToSave)

        Assertions.assertEquals(studentToSave, result)
    }
}