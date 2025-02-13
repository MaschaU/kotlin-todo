package com.personal.todo.domain.valueobject

@JvmInline
value class NoteBody(private val value: String) {
    override fun toString(): String = value

    companion object {
        fun fromString(noteBody: String): NoteBody = NoteBody(noteBody)
    }
}
