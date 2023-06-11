package com.arquitecture.poc.hexagonalarch.adapter.api.controller

import com.arquitecture.poc.hexagonalarch.adapter.api.requests.CreateStudentRequest
import com.arquitecture.poc.hexagonalarch.adapter.api.responses.StudentResponse
import com.arquitecture.poc.hexagonalarch.adapter.api.responses.toStudentResponse
import com.arquitecture.poc.hexagonalarch.domain.ports.input.CreateStudentUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students-management")
class StudentController (

    private val createStudentUseCase: CreateStudentUseCaseInterface

) {
    @PostMapping("/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateStudentRequest): StudentResponse =
        createStudentUseCase.save(request.toStudent())
            .toStudentResponse()
}