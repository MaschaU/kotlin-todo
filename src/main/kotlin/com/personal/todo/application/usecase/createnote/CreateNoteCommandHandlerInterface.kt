package com.personal.todo.application.usecase.createnote

import com.personal.todo.domain.model.Note

interface CreateNoteCommandHandlerInterface {
    fun handle(command: CreateNoteCommand): Note
}