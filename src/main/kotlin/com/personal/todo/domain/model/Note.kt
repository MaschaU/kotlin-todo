package com.personal.todo.domain.model

import com.personal.todo.domain.valueobject.NoteBody
import com.personal.todo.domain.valueobject.NoteId
import com.personal.todo.domain.valueobject.NoteTitle

data class Note(
    val noteTitle: NoteTitle,
    val noteBody: NoteBody,
    val noteId: NoteId,
) {
    companion object {
        private const val NOTE_TITLE = "note_title"
        private const val NOTE_BODY = "note_body"
        private const val NOTE_ID = "note_id"
    }

    fun toMap(): Map<String, String> {
        return mapOf(
            NOTE_TITLE to noteTitle.toString(),
            NOTE_BODY to noteBody.toString(),
            NOTE_ID to noteId.toString(),
        )
    }
}