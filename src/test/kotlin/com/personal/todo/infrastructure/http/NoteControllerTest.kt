package com.personal.todo.infrastructure.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.personal.todo.application.TodoApplication
import com.personal.todo.application.com.personal.todo.infrastructure.http.NoteResponse
import com.personal.todo.application.usecase.createnote.CreateNoteCommand
import com.personal.todo.application.usecase.createnote.CreateNoteCommandHandler
import com.personal.todo.domain.model.Note
import com.personal.todo.infrastructure.http.request.CreateNoteRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest(classes = [TodoApplication::class])
@AutoConfigureMockMvc
class NoteControllerTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper
) {

    @MockBean
    private lateinit var createNoteHandler: CreateNoteCommandHandler

    @Test
    fun `createNote should return 201 Created with valid response`() {
        val request = CreateNoteRequest(
            noteTitle = "Most important TODO",
            noteBody = "TODO: nothing"
        )

        val note = Note(
            noteId = "123e4567-e89b-12d3-a456-426614174000",
            noteTitle = request.noteTitle,
            noteBody = request.noteBody
        )

        val captor = argumentCaptor<CreateNoteCommand>()
        whenever(createNoteHandler.handle(captor.capture())).thenReturn(note)

        val result = mockMvc.post("/api/notes") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(request)
            accept = MediaType.APPLICATION_JSON
        }.andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, NoteResponse::class.java)

        assertEquals(201, result.response.status)
        assertEquals(note.noteId, response.noteId)
        assertEquals(note.noteTitle, response.noteTitle)
        assertEquals(note.noteBody, response.noteBody)
    }

    @Test
    fun `createNote should return 400 Bad Request when request is invalid`() {
        val invalidRequest = mapOf(
            "noteTitle" to "",
            "noteBody" to ""
        )

        val result = mockMvc.post("/api/notes") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidRequest)
            accept = MediaType.APPLICATION_JSON
        }.andReturn()

        assertEquals(400, result.response.status)
    }
}
