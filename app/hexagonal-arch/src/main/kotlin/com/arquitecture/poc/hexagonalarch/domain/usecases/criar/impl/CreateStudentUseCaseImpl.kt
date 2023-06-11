package com.arquitecture.poc.hexagonalarch.domain.usecases.criar.impl

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.enums.ErrorCodes.HEX002
import com.arquitecture.poc.hexagonalarch.domain.exceptions.InvalidStudentException
import com.arquitecture.poc.hexagonalarch.domain.ports.input.CreateStudentUseCaseInterface
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class CreateStudentUseCaseImpl (

    private val studentData: StudentPersistenceInterface
): CreateStudentUseCaseInterface {
    override fun save(student: StudentEntity): StudentEntity {
        if (!student.isValid()) {
            throw InvalidStudentException(HEX002.message.format("Sorry, check the information provided."), HEX002.code)
        }

        return studentData.save(student)
    }
}