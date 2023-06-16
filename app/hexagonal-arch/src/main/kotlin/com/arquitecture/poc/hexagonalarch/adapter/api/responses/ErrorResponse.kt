package com.arquitecture.poc.hexagonalarch.adapter.api.responses

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse (

    var httpCode: Int,
    var message: String?,
    var internalCode: String,
    var errors: List<FieldErrorResponse>?
)