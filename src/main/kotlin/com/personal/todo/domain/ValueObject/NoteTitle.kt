package org.example.com.personal.todo.domain.ValueObject

@JvmInline
value class NoteTitle(private val value: String) {
    override fun toString(): String = value

    companion object {
        fun fromString(noteTitle: String): NoteTitle = NoteTitle(noteTitle)
    }
}
