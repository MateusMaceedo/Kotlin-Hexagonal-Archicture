package com.arquitecture.poc.hexagonalarch.domain.exceptions

class StudentNotFoundException(msg: String, val errorCode: String): RuntimeException(msg)