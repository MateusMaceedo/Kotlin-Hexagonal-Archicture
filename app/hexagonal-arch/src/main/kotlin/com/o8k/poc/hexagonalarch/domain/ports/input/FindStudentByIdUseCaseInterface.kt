package com.o8k.poc.hexagonalarch.domain.ports.input

import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity

interface FindStudentByIdUseCaseInterface {
    fun findById(id: String): StudentEntity
}