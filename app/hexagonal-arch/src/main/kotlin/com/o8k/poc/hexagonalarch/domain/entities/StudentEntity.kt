package com.o8k.poc.hexagonalarch.domain.entities

data class StudentEntity(
    val id: String? = null,
    val name: String
)
{
    fun isValid(): Boolean {
        return name.isNotBlank()
    }
}