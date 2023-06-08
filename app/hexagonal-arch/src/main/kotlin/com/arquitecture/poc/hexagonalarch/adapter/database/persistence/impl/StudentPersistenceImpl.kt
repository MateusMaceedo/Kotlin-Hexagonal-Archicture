package com.arquitecture.poc.hexagonalarch.adapter.database.persistence.impl

import com.arquitecture.poc.hexagonalarch.adapter.database.repository.StudentRepository
import com.arquitecture.poc.hexagonalarch.adapter.database.persistence.toModel
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import org.springframework.data.repository.findByIdOrNull
import javax.inject.Named

@Named
class StudentPersistenceImpl(
    private val studentRepository: StudentRepository
): StudentPersistenceInterface {
    override fun save(student: StudentEntity): StudentEntity {
        return studentRepository.save(student.toModel())
            .toStudent()
    }

    override fun findById(id: String): StudentEntity? {
        return studentRepository.findByIdOrNull(id)
            ?.toStudent()
    }
}