package com.personal.todo.application.createnote

import com.personal.todo.application.usecase.createnote.CreateNoteCommand
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateNoteCommandTest {

    @Test
    fun `should create command with correct properties`() {
        val title = "Test Title"
        val body = "Test Body"
        val tags = "tag1,tag2,tag3"

        val command = CreateNoteCommand(
            noteTitle = title,
            noteBody = body,
            noteTags = tags
        )

        assertEquals(title, command.noteTitle)
        assertEquals(body, command.noteBody)
        assertEquals(tags, command.noteTags)
    }
}