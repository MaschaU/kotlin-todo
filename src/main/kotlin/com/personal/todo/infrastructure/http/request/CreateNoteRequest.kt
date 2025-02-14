package com.personal.todo.infrastructure.http.request

import jakarta.validation.constraints.NotBlank


data class CreateNoteRequest(
    @field:NotBlank(message = "Title cannot be empty")
    val noteTitle: String,

    @field:NotBlank(message = "Body cannot be empty")
    val noteBody: String
)