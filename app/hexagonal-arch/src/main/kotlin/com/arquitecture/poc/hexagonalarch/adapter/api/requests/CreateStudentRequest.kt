package com.arquitecture.poc.hexagonalarch.adapter.api.requests

import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity

data class CreateStudentRequest (
    var name: String
) {
    fun toStudent() = StudentEntity (
        name = name
    )
}