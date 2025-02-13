package com.personal.todo.application.usecase.createnote

import com.personal.todo.domain.model.Note
import com.personal.todo.domain.repository.NoteRepository
import java.util.*


class CreateNoteCommandHandler(
    private val notesRepository: NoteRepository,
): CreateNoteCommandHandlerInterface
{
    override fun handle(command: CreateNoteCommand) {

        val note = Note(
            noteTitle = command.noteTitle,
            noteBody = command.noteBody,
            noteId = UUID.randomUUID().toString()
        )

        notesRepository.createNote(note)
    }
}
