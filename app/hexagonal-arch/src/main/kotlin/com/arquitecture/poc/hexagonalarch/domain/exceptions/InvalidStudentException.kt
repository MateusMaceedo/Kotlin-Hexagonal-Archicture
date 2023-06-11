package com.arquitecture.poc.hexagonalarch.domain.exceptions

class InvalidStudentException(msg: String, val errorCode: String): RuntimeException(msg)