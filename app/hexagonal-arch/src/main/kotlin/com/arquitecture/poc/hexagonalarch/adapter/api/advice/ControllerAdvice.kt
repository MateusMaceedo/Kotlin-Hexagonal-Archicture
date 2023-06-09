package com.arquitecture.poc.hexagonalarch.adapter.api.advice

import com.arquitecture.poc.hexagonalarch.adapter.api.responses.ErrorResponse
import com.arquitecture.poc.hexagonalarch.domain.exceptions.InvalidStudentException
import com.arquitecture.poc.hexagonalarch.domain.exceptions.StudentNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(StudentNotFoundException::class)
    fun handlerStudentNotFoundException(
        ex: StudentNotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(InvalidStudentException::class)
    fun handlerStudentInvalidStudentException(
        ex: InvalidStudentException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}