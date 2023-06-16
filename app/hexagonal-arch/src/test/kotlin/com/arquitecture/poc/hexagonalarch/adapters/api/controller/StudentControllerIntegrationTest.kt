package com.arquitecture.poc.hexagonalarch.adapters.api.controller

import com.arquitecture.poc.hexagonalarch.adapter.api.responses.StudentResponse
import com.arquitecture.poc.hexagonalarch.adapters.api.BaseApiIntegrationTest
import com.arquitecture.poc.hexagonalarch.domain.entities.StudentEntity
import com.arquitecture.poc.hexagonalarch.domain.ports.output.StudentPersistenceInterface
import com.arquitecture.poc.hexagonalarch.templates.StudentsRequestsTemplate
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class StudentControllerIntegrationTest: BaseApiIntegrationTest() {

    companion object {
        const val BASE_URL: String = "/students-management/v1/students"
    }

    @Autowired
    lateinit var studentData: StudentPersistenceInterface

    private val objectMapper = ObjectMapper()

    @Test
    fun `should save a student`() {

        val body = StudentsRequestsTemplate.buildCreateRequest()

        val result = mvc.perform(
            post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        )

            .andExpect(status().is2xxSuccessful)
            .andReturn()

        val studentResponse = objectMapper.readValue(result.response.contentAsString, StudentResponse::class.java)
        Assertions.assertEquals("Student Test", studentResponse.name)

        val savedStudent = studentData.findById(studentResponse.id)
        Assertions.assertEquals(studentResponse.id, savedStudent?.id)
    }

    @Test
    fun `should find a student by id`() {

        val studentToSave = StudentEntity("abc", "Student Test")
        studentData.save(studentToSave)

        mvc.perform (
            get("$BASE_URL/abc")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().is2xxSuccessful)
            .andExpect(jsonPath("id", `is`("abc")))
    }
}