package com.personal.todo.domain.valueobject

@JvmInline
value class NoteTitle(private val value: String) {
    override fun toString(): String = value

    companion object {
        fun fromString(noteTitle: String): NoteTitle = NoteTitle(noteTitle)
    }
}
