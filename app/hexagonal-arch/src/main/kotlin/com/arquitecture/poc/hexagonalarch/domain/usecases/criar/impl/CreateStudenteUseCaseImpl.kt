package com.arquitecture.poc.hexagonalarch.domain.usecases.criar.impl

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.exceptions.InvalidStudentException
import com.arquitecture.poc.hexagonalarch.domain.ports.input.CreateStudentUseCaseInterface
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface

class CreateStudenteUseCaseImpl (

    private val studenteData: StudentPersistenceInterface
): CreateStudentUseCaseInterface {
    override fun save(student: StudentEntity): StudentEntity {
        if (!student.isValid()) {
            throw InvalidStudentException("Student is valid")
        }

        return studenteData.save(student)
    }
}