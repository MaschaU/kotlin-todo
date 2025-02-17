package com.personal.todo.domain.repository

import com.personal.todo.domain.model.Note

interface NoteRepository {
    fun createNote(note: Note)
}