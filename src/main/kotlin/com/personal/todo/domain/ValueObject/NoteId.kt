package com.personal.todo.domain.valueobject

data class NoteId private constructor(private val noteId: String) {

    init {
        try {
            java.util.UUID.fromString(noteId)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid UUID string: $noteId")
        }
    }

    companion object {
        fun fromString(noteId: String): NoteId = NoteId(noteId)
    }

    override fun toString(): String = noteId
}
