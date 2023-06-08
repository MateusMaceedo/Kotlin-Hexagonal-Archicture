package com.arquitecture.poc.hexagonalarch.domain.ports.output

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity

interface StudentPersistenceInterface {
    // comando que o dominio delega para fora dele
    fun save(student: StudentEntity): StudentEntity
    //  pode retornar um student ou não
    fun findById(s: String): StudentEntity?
}