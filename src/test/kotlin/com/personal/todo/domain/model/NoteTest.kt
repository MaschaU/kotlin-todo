package com.personal.todo.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NoteTest {
    @Test
    fun `should create note with correct properties`() {
        val title = "Highest priority TODO"
        val body = "TODO Everything"
        val id = "123e4567-e89b-12d3-a456-426614174000"

        val note = Note(
            noteTitle = title,
            noteBody = body,
            noteId = id
        )

        assertEquals(title, note.noteTitle)
        assertEquals(body, note.noteBody)
        assertEquals(id, note.noteId)
    }
}