package com.personal.todo.application.createnote

import com.personal.todo.application.usecase.createnote.CreateNoteCommand
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateNoteCommandTest {

    @Test
    fun `should create command with correct properties`() {
        val title = "Test Title"
        val body = "Test Body"
        val id = "123e4567-e89b-12d3-a456-426614174000"

        val command = CreateNoteCommand(
            noteTitle = title,
            noteBody = body,
            noteId = id
        )

        assertEquals(title, command.noteTitle)
        assertEquals(body, command.noteBody)
        assertEquals(id, command.noteId)
    }
}