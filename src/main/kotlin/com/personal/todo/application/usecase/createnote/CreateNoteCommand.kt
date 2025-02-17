package com.personal.todo.application.usecase.createnote

data class CreateNoteCommand(
    val noteId: String,
    val noteTitle: String,
    val noteBody: String
)
