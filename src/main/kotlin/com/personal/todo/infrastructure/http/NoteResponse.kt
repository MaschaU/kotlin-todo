package com.personal.todo.application.com.personal.todo.infrastructure.http

data class NoteResponse(
    val noteId: String,
    val noteTitle: String,
    val noteBody: String
)