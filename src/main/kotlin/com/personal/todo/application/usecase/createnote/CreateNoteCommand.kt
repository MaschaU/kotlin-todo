package com.personal.todo.application.usecase.createnote

data class CreateNoteCommand(
    val noteTitle: String,
    val noteBody: String,
    val noteTags: String
)
