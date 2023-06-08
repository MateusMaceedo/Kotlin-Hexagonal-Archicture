package com.arquitecture.poc.hexagonalarch.adapter.api.controller

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.exceptions.StudentNotFoundException
import com.arquitecture.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
class StudentController (
    private val findStudentByIdUseCase: FindStudentByIdUseCaseInterface
) {
    @GetMapping("/{id}")
    fun findStudentById(@PathVariable id: String): ResponseEntity<StudentEntity> {
        try {
            val student = findStudentByIdUseCase.findById(id)
            return ResponseEntity.ok(student)
        } catch (e: StudentNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}