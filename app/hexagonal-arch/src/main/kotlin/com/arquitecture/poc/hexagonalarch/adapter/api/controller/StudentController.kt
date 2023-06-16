package com.arquitecture.poc.hexagonalarch.adapter.api.controller

import com.arquitecture.poc.hexagonalarch.adapter.api.requests.CreateStudentRequest
import com.arquitecture.poc.hexagonalarch.adapter.api.responses.StudentResponse
import com.arquitecture.poc.hexagonalarch.adapter.api.responses.toStudentResponse
import com.arquitecture.poc.hexagonalarch.domain.ports.input.CreateStudentUseCaseInterface
import com.arquitecture.poc.hexagonalarch.domain.ports.input.FindStudentByIdUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students-management")
class StudentController(

    private val createStudentUseCase: CreateStudentUseCaseInterface,
    private val findStudentByIdUseCaseInterface: FindStudentByIdUseCaseInterface

) {
    @PostMapping("/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateStudentRequest): StudentResponse =
        createStudentUseCase.save(request.toStudent())
            .toStudentResponse()

    @GetMapping("v1/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): StudentResponse =
        findStudentByIdUseCaseInterface.findById(id)
            .toStudentResponse()
}