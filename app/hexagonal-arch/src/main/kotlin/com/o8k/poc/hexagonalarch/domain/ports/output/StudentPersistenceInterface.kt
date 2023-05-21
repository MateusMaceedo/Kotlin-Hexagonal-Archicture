package com.o8k.poc.hexagonalarch.domain.ports.output

import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity

interface StudentPersistenceInterface {
    fun save(student: StudentEntity): StudentEntity
}