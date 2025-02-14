package com.personal.todo.application.usecase.createnote

import com.personal.todo.domain.model.Note
import com.personal.todo.domain.repository.NoteRepository
import java.util.*


class CreateNoteCommandHandler(
    private val notesRepository: NoteRepository,
) : CreateNoteCommandHandlerInterface {
    override fun handle(command: CreateNoteCommand): Note {
        val note = Note(
            noteId = UUID.randomUUID().toString(),
            noteTitle = command.noteTitle,
            noteBody = command.noteBody
        )
        notesRepository.createNote(note)
        return note
    }
}
