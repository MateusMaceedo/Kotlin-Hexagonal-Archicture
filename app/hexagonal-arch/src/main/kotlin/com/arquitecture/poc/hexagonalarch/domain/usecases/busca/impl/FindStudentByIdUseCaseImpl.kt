package com.arquitecture.poc.hexagonalarch.domain.usecases.busca.impl

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.enums.ErrorCodes.HEX001
import com.arquitecture.poc.hexagonalarch.domain.exceptions.StudentNotFoundException
import com.arquitecture.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class FindStudentByIdUseCaseImpl(

    private val student: StudentPersistenceInterface

): FindStudentByIdUseCaseInterface {
    override fun findById(id: String): StudentEntity {

        return student.findById(id)
            ?: throw StudentNotFoundException(HEX001.message.format("Student with id: $id"), HEX001.code)
    }
}