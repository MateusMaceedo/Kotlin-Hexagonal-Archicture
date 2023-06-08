package com.arquitecture.poc.hexagonalarch.domain.ports.input

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity

interface FindStudentByIdUseCaseInterface {
    fun findById(id: String): StudentEntity
}