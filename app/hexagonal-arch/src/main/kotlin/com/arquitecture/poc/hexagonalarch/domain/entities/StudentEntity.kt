package com.arquitecture.poc.hexagonalarch.domain.entities

data class StudentEntity(
    val id: String? = null,
    val name: String
) {
    fun isValid(): Boolean {
        return name.isNotBlank()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StudentEntity

        if (id != other.id) return false
        return name == other.name
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "StudentEntity(id=$id, name='$name')"
    }
}