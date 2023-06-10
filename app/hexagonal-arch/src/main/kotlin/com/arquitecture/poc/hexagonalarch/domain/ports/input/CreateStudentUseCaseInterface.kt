package com.arquitecture.poc.hexagonalarch.domain.ports.input

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity

interface CreateStudentUseCaseInterface {
    fun save(student: StudentEntity): StudentEntity
}