package com.personal.todo.domain.valueobject

@JvmInline
value class NoteId private constructor(val noteId: String) {
    init {
        require(runCatching { java.util.UUID.fromString(noteId) }.isSuccess) {
            "Invalid UUID string: $noteId"
        }
    }

    companion object {
        fun fromString(noteId: String): NoteId = NoteId(noteId)
    }

    override fun toString(): String = noteId
}
