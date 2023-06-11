package com.arquitecture.poc.hexagonalarch.templates

class StudentsRequestsTemplate {

    companion object {
        fun buildCreateRequest(): String {
            return """{ "name": "Student Test" }"""
        }
    }
}