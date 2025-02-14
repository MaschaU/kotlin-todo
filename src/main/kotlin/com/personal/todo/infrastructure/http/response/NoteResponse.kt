package com.personal.todo.infrastructure.http.response

data class NoteResponse(
    val noteId: String,
    val noteTitle: String,
    val noteBody: String
)