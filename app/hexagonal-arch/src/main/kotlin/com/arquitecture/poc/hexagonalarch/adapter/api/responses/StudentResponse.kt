package com.arquitecture.poc.hexagonalarch.adapter.api.responses

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity

data class StudentResponse (
    var id: String = "",
    var name: String = ""
)

fun StudentEntity.toStudentResponse() = StudentResponse(
    id = id!!,
    name = name
)