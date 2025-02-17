package com.personal.todo.application.com.personal.todo.infrastructure.http

import com.personal.todo.application.usecase.createnote.CreateNoteCommand
import com.personal.todo.application.usecase.createnote.CreateNoteCommandHandler
import com.personal.todo.infrastructure.http.request.CreateNoteRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/notes")
class NoteController(
    private val createNoteHandler: CreateNoteCommandHandler
) {
    @PostMapping
    fun createNote(
        @Valid @RequestBody request: CreateNoteRequest
    ): ResponseEntity<NoteResponse> {
        val command = CreateNoteCommand(
            noteId = UUID.randomUUID().toString(),
            noteTitle = request.noteTitle,
            noteBody = request.noteBody
        )

        val note = createNoteHandler.handle(command)

        val response = NoteResponse(
            noteId = note.noteId,
            noteTitle = note.noteTitle,
            noteBody = note.noteBody
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}