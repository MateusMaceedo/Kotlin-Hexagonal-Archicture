package com.arquitecture.poc.hexagonalarch.adapter.database.repository

import com.arquitecture.poc.hexagonalarch.adapter.database.persistence.StudentModel
import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Named

@Named
interface StudentRepository: JpaRepository<StudentModel, String>