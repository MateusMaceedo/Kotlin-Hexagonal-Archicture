package com.o8k.poc.hexagonalarch.adapter.database.persistence.impl

import com.o8k.poc.hexagonalarch.adapter.database.repository.StudentRepository
import com.o8k.poc.hexagonalarch.adapter.database.persistence.toModel
import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity
import com.o8k.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
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