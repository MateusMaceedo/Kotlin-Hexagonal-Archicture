package com.o8k.poc.hexagonalarch.adapter.database.persistence

import com.o8k.poc.hexagonalarch.domain.entities.StudentEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "students")
data class StudentModel(
    @Id
    var id: String = "",
    @Column
    var name: String = ""
) {
    fun toStudent() = StudentEntity(
        id = id,
        name = name
    )
}

fun StudentEntity.toModel() = StudentModel(
    id = id ?: UUID.randomUUID().toString(),
    name = name
)