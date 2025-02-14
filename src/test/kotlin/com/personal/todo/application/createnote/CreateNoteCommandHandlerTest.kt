package com.personal.todo.application.createnote

import com.personal.todo.application.usecase.createnote.CreateNoteCommand
import com.personal.todo.application.usecase.createnote.CreateNoteCommandHandler
import com.personal.todo.domain.model.Note
import com.personal.todo.domain.repository.NoteRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.verify


class CreateNoteCommandHandlerTest {
    private lateinit var notesRepository: NoteRepository
    private lateinit var handler: CreateNoteCommandHandler

    @BeforeEach
    fun setup() {
        notesRepository = mock()

        handler = CreateNoteCommandHandler(notesRepository)
    }

    @Test
    fun `should create note with correct properties and save it`() {
        val command = CreateNoteCommand(
            noteId = "random-generated-id",
            noteTitle = "Test Title",
            noteBody = "Test Body"
        )

        handler.handle(command)

        // TODO: look into argument captor
        val note = argumentCaptor<Note>()

        verify(notesRepository, times(1)).createNote(note.capture())

        val expectedNote = note.firstValue
        assertEquals(command.noteTitle, expectedNote.noteTitle)
        assertEquals(command.noteBody, expectedNote.noteBody)
        assertNotNull(expectedNote.noteId)
    }
}