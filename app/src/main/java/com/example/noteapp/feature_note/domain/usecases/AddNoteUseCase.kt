package com.example.noteapp.feature_note.domain.usecases

import com.example.noteapp.feature_note.domain.model.InvalidNoteException
import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepo

class AddNoteUseCase(
    private val repo: NoteRepo
) {

    // Throwing a custom exception for invalid note
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        // Checking for valid note
        // Putting the business logic in the use case
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repo.insertNote(note)
    }
}