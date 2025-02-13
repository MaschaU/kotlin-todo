package com.personal.todo.application.usecase.createnote

interface CreateNoteCommandHandlerInterface {
    fun handle(command: CreateNoteCommand)
}