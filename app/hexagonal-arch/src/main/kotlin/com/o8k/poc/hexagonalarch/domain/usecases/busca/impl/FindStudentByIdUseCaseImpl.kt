package com.o8k.poc.hexagonalarch.domain.usecases.busca.impl

import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity
import com.o8k.poc.hexagonalarch.domain.exceptions.StudentNotFoundException
import com.o8k.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import com.o8k.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface

class FindStudentByIdUseCaseImpl(

    private val student: StudentPersistenceInterface

): FindStudentByIdUseCaseInterface {
    override fun findById(id: String): StudentEntity {

        return student.findById(id)
            ?: throw StudentNotFoundException("Student not found")
    }
}